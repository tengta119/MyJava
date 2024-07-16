package DrawingBoaard.v2;
import java.awt.*;
import java.util.Random;

public class Shape
{
    String str;
    int x1,y1,x2,y2;
    Color color;
    int count = 0;
    Shape(String str,int x1,int y1,int x2,int y2,Color color)
    {
        this.str = str;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;

    }



    public void draw(Graphics g)
    {
        g.setColor(color);
        switch (str)
        {
            case "直线":
                g.drawLine(x1, y1, x2, y2);
                break;
            case "矩形":
                g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                break;
            case "实心矩形":
                g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                break;
            case "圆形":
                g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                break;
            case "实心圆形":
                g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                break;
            case "等腰三角形":
                g.drawLine(x1,y1,x2,y2);
                g.drawLine(x2,y1,(x1+x2)/2,y2);
                g.drawLine((x1+x2)/2,y2,x1,y1);
                break;
            case "立方体":
                cube(g,x1,y1,x2,y2);
                break;
            case "谢尔宾斯基三角形":
                double[] third = thirdVertexUnder(x1,y1,x2,y2);
                triangle(g,x1,y1,x2,y2,(int)third[0],(int)third[1]);
                SierpinskiTriangle( g, x1,  y1,  x2,  y2);
                break;
            case "曲线":
                curve(g,x1,y1,x2,y2,500);
        }
    }

    public  double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }//计算两边长度

    public double[] MidpointCoordinates(double x1, double y1, double x2, double y2)
    {
        double midX = (x1 + x2) / 2;
        double mixY = (y1 + y2) / 2;

        return new double[]{midX,mixY};
    }//计算中点坐标

    public  double[] thirdVertexUnder(double x1, double y1, double x2, double y2)
    {
        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;


        double baseLength = distance(x1, y1, x2, y2);
        double height = baseLength * Math.sqrt(3) / 2;


        double thirdX = midX;
        double thirdY = midY - height;


        return new double[]{thirdX, thirdY};
    }//计算三角形顶点坐标(under)

    public  double[] thirdVertexUp(double x1, double y1, double x2, double y2)
    {
        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;


        double baseLength = distance(x1, y1, x2, y2);
        double height = baseLength * Math.sqrt(3) / 2;


        double thirdX = midX;
        double thirdY = midY + height;


        return new double[]{thirdX, thirdY};
    }//计算三角形顶点坐标(up)

    public void triangle(Graphics g ,int x1,int y1,int x2,int y2,int x3,int y3 )
    {
        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2,x3,y3);
        g.drawLine(x3,y3,x1,y1);
    }

    public void filltriangle(Graphics g, double x1, double y1, double x2, double y2, double x3, double y3)
    {
        int[] xp = {(int)x1, (int)x2, (int)x3};
        int[] yp = {(int)y1, (int)y2, (int)y3};
        g.fillPolygon(xp,yp,3);
    }

    public void cube(Graphics g,int x1,int y1,int x2,int y2)
    {
        double l = distance(x1,y1,x2,y2);
        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2, (int) (x2+0.5*l), (int) (y2+0.5*l));
        g.drawLine((int) (x2+0.5*l), (int) (y2+0.5*l),(int) (x1+0.5*l), (int) (y1+0.5*l));
        g.drawLine((int) (x1+0.5*l), (int) (y1+0.5*l),x1,y1);

        g.drawLine(x1,(int)(y1+l),x2,(int) (y2+l));
        g.drawLine(x2,(int) (y2+l),(int) (x2+0.5*l), (int) (y2+1.5*l));
        g.drawLine((int) (x2+0.5*l), (int) (y2+1.5*l),(int) (x1+0.5*l), (int) (y1+1.5*l));
        g.drawLine((int) (x1+0.5*l), (int) (y1+1.5*l),x1,(int)(y1+l));

        g.drawLine(x1,y1,x1,(int)(y1+l));
        g.drawLine(x2,y2,x2,(int)(y2+l));
        g.drawLine((int) (x2+0.5*l), (int) (y2+0.5*l),(int) (x2+0.5*l), (int) (y2+1.5*l));
        g.drawLine((int) (x1+0.5*l), (int) (y1+0.5*l),(int) (x1+0.5*l), (int) (y1+1.5*l));
    }//立方体

    public void SierpinskiTriangle(Graphics g,int x1, int y1, int x2, int y2)
    {
        if(distance(x1,y2,x2,y2)<10)
        {
            return;
        }

        double[] third = thirdVertexUnder(x1,y1,x2,y2);
        double[] mid1 = MidpointCoordinates(x1,y1,x2,y2);
        double[] mid2 = MidpointCoordinates(x2,y2,third[0],third[1]);
        double[] mid3 = MidpointCoordinates(third[0],third[1],x1,y1);
        filltriangle(g,mid1[0],mid1[1],mid2[0],mid2[1],mid3[0],mid3[1]);

        SierpinskiTriangle(g,x1,y1,(int)mid1[0],(int)mid1[1]);
        SierpinskiTriangle(g,x2,y2,(int)mid1[0],(int)mid1[1]);
        SierpinskiTriangle(g,(int)mid2[0],(int)mid2[1],(int)mid3[0],(int)mid3[1]);
    }

    public void curve(Graphics g,int x1,int y1,int x2,int y2,int n)
    {
        Random random = new Random();
        int rand = random.nextInt(n)-n/2;
        if(n<=5)
        {
            g.drawLine(x1,y1,x2,y2);
            return;
        }

        curve(g,x1,y1,(x1+x2)/2,(y1+y2)/2+rand,n/2);
        curve( g,(x1+x2)/2,(y1+y2)/2+rand,x2,y2,n/2);


    }



}

