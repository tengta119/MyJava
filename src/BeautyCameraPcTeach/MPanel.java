package BeautyCameraPcTeach;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MPanel extends JPanel {
    private  BufferedImage[] bufferedImageArr;

    public void setBufferedImageArr(BufferedImage[] bufferedImageArr){
        this.bufferedImageArr = bufferedImageArr;
    }

    //重写paint方法
    public void paint(Graphics g){
        //1.保留绘制组件的功能
        super.paint(g);
        System.out.println("paint...");

        //2.重绘图像内容
        for(int i=0;i<bufferedImageArr.length;i++){
            BufferedImage bufferedImages = bufferedImageArr[i];
            if(bufferedImages != null){
                g.drawImage(bufferedImages,0,0,null);
            }
        }
    }
}

