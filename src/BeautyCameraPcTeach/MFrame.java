package BeautyCameraPcTeach;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//自定义窗体类
public class MFrame extends JFrame {
    private BufferedImage[] bufferedImageArr;

    //定义set
    public void setBufferedImage(BufferedImage[] bufferedImageArr)
    {
        System.out.println("MFrameSetBufferedImage");
        this.bufferedImageArr = bufferedImageArr;
    }

    //重写窗体的paint方法
    public void paint(Graphics g){
        //1.保留绘制组件的功能
        //super 表示当前类的父类对象
        //this 表示本类对象
        super.paint(g);

        System.out.println("paint....");

        //2.绘制图像效果
        g.drawImage(bufferedImageArr[0],0,100,null);

    }
}
