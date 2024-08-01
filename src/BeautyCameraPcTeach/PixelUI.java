package BeautyCameraPcTeach;
import javax.swing.*;
import java.awt.*;
public class PixelUI {

    public void initUI(){
        //JFrame 默认是边框布局
        JFrame jf = new JFrame();
        jf.setTitle("美颜相机");
        jf.setSize(900,900);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);

        //面板对象
        //JPanel 默认流式布局
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.GREEN);
        northPanel.setPreferredSize(new Dimension(0,50));
        jf.add(northPanel,BorderLayout.NORTH);

        MPanel pixelPanel = new MPanel();
        pixelPanel.setBackground(Color.WHITE);
        jf.add(pixelPanel,BorderLayout.CENTER);

        PixelListener listener = new PixelListener(pixelPanel);

        String[] name = {"撤回","原图","马赛克","灰度","右转","左转","放大","缩小"};
        for(int i=0;i<name.length;i++) {
            JButton jbu = new JButton(name[i]);
            northPanel.add(jbu);
            jbu.addActionListener(listener);
        }


        jf.setVisible(true);

        listener.setG(pixelPanel.getGraphics());

        //把保存图像的数据从PixelListener类传递到MPanel类中
        pixelPanel.setBufferedImageArr(listener.getBufferedImageArr());


    }

    public static void main(String[] args) {
        new PixelUI().initUI();
    }
}
