package BeautyCameraPcTeach;
import java.awt.*;
import java.awt.image.BufferedImage;

//滤镜效果
public class FilterImage {
    private int[][] pixelArr;  //图片的像素值
    private  BufferedImage[] bufferedImageArr;
    private int index = 0;  //记录图层
    private int max;

    public FilterImage(int[][] pixelArr,BufferedImage[] bufferedImageArr){
        this.pixelArr = pixelArr;
        this.bufferedImageArr = bufferedImageArr;
        max=0;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public int getMax() {
        return max;
    }
    public int getIndex(){
        return index;
    }

    //原图
    public void drawPixel(Graphics g){
        //缓存图片
        BufferedImage bufferedImage = new BufferedImage(pixelArr[0].length,pixelArr.length,
                BufferedImage.TYPE_INT_RGB);
        Graphics buffG = bufferedImage.getGraphics();
        for(int i=0;i<pixelArr.length;i++){
            for(int j=0;j<pixelArr[0].length;j++){
                int pixel = pixelArr[i][j];
                Color color = new Color(pixel);
                buffG.setColor(color);
                buffG.fillRect(j,i,1,1);
            }
        }
        g.drawImage(bufferedImage,0,0,bufferedImage.getWidth()+(max*50),bufferedImage.getHeight()+(max*50),null);
        bufferedImageArr[index++] = bufferedImage;
    }
    //灰度
    public void gray(Graphics g){
        BufferedImage bufferedImage = new BufferedImage(pixelArr[0].length,pixelArr.length,
                BufferedImage.TYPE_INT_RGB);
        Graphics buffG = bufferedImage.getGraphics();
        for(int i=0;i<pixelArr.length;i++){
            for(int j=0;j<pixelArr[0].length;j++){
                int pixel = pixelArr[i][j];
                //取出三原色
                int red = pixel>>16 & 0xFF;
                int green = pixel>>8 & 0xFF;
                int blue = pixel>>0 & 0xFF;
                int num = (red+green+blue)/3;
                Color color = new Color(num,num,num);
                buffG.setColor(color);
                buffG.fillRect(j,i,1,1);
            }
        }
        g.drawImage(bufferedImage,0,0,null);
        bufferedImageArr[index++] = bufferedImage;
    }
    //旋转
    //ArrayIndexOutOfBoundsException：数组下标越界
    public void rightRotate()
    {
        //用新数组保存旋转后的数据
        int[][] nPixelArr = new int[pixelArr[0].length][pixelArr.length];
        for(int i=0;i<pixelArr.length;i++){
            for(int j=0;j<pixelArr[0].length;j++){
                nPixelArr[j][pixelArr.length-1-i] = pixelArr[i][j];
            }
        }
        pixelArr = nPixelArr;
    }
}
