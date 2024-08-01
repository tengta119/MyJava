package BeautyCameraPcTeach;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class PixelListener implements  ActionListener {
    private Graphics g;
    private int[][] pixelArr;
    private FilterImage filter;
    private  BufferedImage[] bufferedImageArr = new BufferedImage[100];
    private MPanel pixelPanel;

    public PixelListener( MPanel pixelPanel)
    {
        this.pixelPanel = pixelPanel;
        String path = "D:\\chen\\图片\\2.jpg";
        pixelArr = getImagePixel(path);
        filter = new FilterImage(pixelArr,bufferedImageArr);

    }
    public void setG(Graphics g){
        this.g = g;
    }
    public BufferedImage[] getBufferedImageArr(){
        return bufferedImageArr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取按钮上内容
        String name = e.getActionCommand();
        switch (name){
            case "原图":
                filter.drawPixel(g);
                break;
            case "灰度":
                filter.gray(g);
                break;
            case "撤回":
                //删除最后一个图层
                bufferedImageArr[filter.getIndex()-1] = null;
                //刷新面板
                pixelPanel.repaint();
                break;
            case "右转":
                filter.rightRotate();
                filter.drawPixel(g);
                break;
            case "放大":
                filter.setMax(filter.getMax()+1);
                filter.drawPixel(g);
                break;
        }

    }
    //读取图片数据
    public int[][] getImagePixel(String path)
    {
        File file = new File(path);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int[][] pixelArr = new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                int pixel = bufferedImage.getRGB(j,i);
                pixelArr[i][j] = pixel;
            }
        }
        return pixelArr;
    }
}
