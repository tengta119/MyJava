package DrawingBoaard.initial;
import java.awt.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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
                g.drawLine(x1,y1,x2,y1);
                g.drawLine(x2,y1,(x1+x2)/2,y2);
                g.drawLine((x1+x2)/2,y2,x1,y1);
            case "立方体":
                double l =  (sqrt(pow(x1-x2,2) + pow(y1-y2,2)));
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

            case "三角形":





        }
    }
}
