package DrawingBoaard.v2;

import javax.swing.*;
import java.awt.*;

public class DrawingShow
{

    public void show()
    {
        DrawFun dl = new DrawFun();

        MyJFrame draw = new MyJFrame();
        draw.setTitle("画板");
        draw.setSize(800,500);
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw.setLocationRelativeTo(null);
        draw.setLayout(new FlowLayout());
        draw.addMouseListener(dl);




        String[] btnTexts = {"直线", "矩形", "圆形", "实心矩形", "实心圆形", "等腰三角形", "三角形", "多边形","谢尔宾斯基三角形", "曲线","立方体", "球", "橡皮擦", "撤回", "保存"};
        for (String btnText : btnTexts)
        {
            JButton btn = new JButton(btnText);
            draw.add(btn);
            btn.addActionListener(dl);
        }//将这些按钮添加到draw容器中，同时为每个按钮添加一个动作监听器

        Color[] colors = {Color.BLACK, Color.WHITE, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK,};
        for(Color color : colors)
        {
            JButton btn = new JButton(" ");
            btn.setBackground(color);
            draw.add(btn);
            btn.addActionListener(dl);

        }//将这些按钮添加到draw容器中，同时为每个按钮添加一个动作监听器


        draw.setVisible(true);
        Graphics g = draw.getGraphics();
        dl.setG(g);
        draw.shapeList = dl.myshape;
    }

     public static void main(String[] args)
     {
         DrawingShow test = new DrawingShow();
         test.show();

     }



}
