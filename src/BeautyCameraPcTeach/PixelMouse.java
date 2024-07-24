package BeautyCameraPcTeach;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
public class PixelMouse implements MouseListener, ActionListener {
    //属性：引用传递(初始化属性)
    private Graphics g;
    private BufferedImage[] bufferedImageArr = new BufferedImage[1];

    public PixelMouse(Graphics g)
    {
        this.g = g;
    }
    public PixelMouse() {}
    //定义set方法，初始化属性
    //当修改对象的属性时必须用set 方法
    public void setGr(Graphics g) {
        this.g = g;
    }

    //定义get
    public  BufferedImage[] getBufferedImageArr()
    {
        System.out.println("MouseGtBufferedImageArr");
        return bufferedImageArr;
    }

    public void actionPerformed(ActionEvent e){
        String path = "D:\\Jave\\1.png";
        int[][] pixelArr = getImagePixel(path);

        //获取按钮上的内容
        String name = e.getActionCommand();
        switch (name){
            case "原图":

                break;
            case "灰度":
                drawPixel(pixelArr);
                break;
            case "马赛克":
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击！！！");

    }

    //根据像素点绘制图片
    //1.马赛克,灰度，底片，浮雕，，，
    //程序 > jvm > os > 总线 > 屏幕
    public void drawPixel(int[][] pixelArr) {

        //创建缓冲图片，保存处理后的像素点
        BufferedImage bufferedImage = new BufferedImage(pixelArr[0].length,pixelArr.length,
                BufferedImage.TYPE_INT_RGB);

        //获取缓冲图片画笔
        Graphics buffG = bufferedImage.getGraphics();

        //根据保存的像素值转成Color 对象
        //把color 设置给画笔，画像素点
        for (int i = 0; i < pixelArr.length; i++) {
            for (int j = 0; j < pixelArr[0].length; j++) {
                int pixel = pixelArr[i][j];
                //右移，把int 拆分成3个byte
                int red =  (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue =  (pixel >> 0) & 0xFF;

                //取平均值
                int num = (red+green+blue)/3;
                Color color = new Color(num, num, num);
                buffG.setColor(color);
                buffG.fillRect(j,i,1,1);
            }
        }
        //把缓存图片画在窗体上
        //多态
        g.drawImage(bufferedImage,0,100,null);
        //保存到数组中
        bufferedImageArr[0] = bufferedImage;

    }

    //根据指定路径获取图片的像素值
    public int[][] getImagePixel(String path) {
        //创建图片文件
        File file = new File(path);

        //输入流读取图片文件数据
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //根据图片大小定义二维数组保存像素值
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int[][] pixelArr = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //获取每个像素点的值
                int pixel = bufferedImage.getRGB(j, i);
                pixelArr[i][j] = pixel;
            }
        }
        return pixelArr;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
