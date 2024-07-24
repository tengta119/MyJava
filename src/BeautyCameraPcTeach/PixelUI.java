package BeautyCameraPcTeach;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelUI
{
    //显示美颜相机操作界面
    public void initUI(){
        MFrame jf = new MFrame();
        jf.setTitle("美颜相机");
        jf.setSize(900,900);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);

        jf.setLayout(new FlowLayout());

        PixelMouse mouse = new PixelMouse();
        String[] name = {"原图","马赛克","灰度"};
        for(int i=0;i<name.length;i++) {
            //功能按钮
            JButton jbu = new JButton(name[i]);
            jf.add(jbu);
            jbu.addActionListener(mouse);
        }

        jf.setVisible(true);

        //画笔：从窗体上获取画笔，一定要在窗体显示可见之后
        Graphics g = jf.getGraphics();

        //给窗体添加鼠标监听器方法
        // 类名 对象名 = new 构造方法;

        jf.addMouseListener(mouse);

        //把画笔对象传递给PixelMouse类
        mouse.setGr(g);

        //把缓存图片从PixelMouse 传递到 MFrame 类中
        BufferedImage[] bufferedImageArr = mouse.getBufferedImageArr();
        jf.setBufferedImage(bufferedImageArr);
    }

    public static void main(String[] args) {
        PixelUI ui = new PixelUI();
        ui.initUI();
    }

}
