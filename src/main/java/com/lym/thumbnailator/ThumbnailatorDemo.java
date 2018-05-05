package com.lym.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 使用google提供的Thumbnailator 工具操作图片demo
 *
 * 实现功能:
 *  1、缩放图片
 *  2、压缩图片
 *  3、裁剪图片
 *  4、旋转图片
 *  5、添加水印
 *  6、批量处理图片
 *
 * Created by 刘彦民 on 2018/5/5.
 */
public class ThumbnailatorDemo {

    private File imgFile;
    private File imgFile1;
    private File imgFile2;
    private File imgFile3;

    @Before
    public void init() {
        // 图片路径
        imgFile = new File("D:/tmp/img/test/thumb/test.png");
        imgFile1 = new File("D:/tmp/img/test/thumb/test1.png");
        imgFile2 = new File("D:/tmp/img/test/thumb/test2.png");
        imgFile3 = new File("D:/tmp/img/test/thumb/test3.png");
    }

    /**
     * 把生成的图片输出到流中
     */
    @Test
    public void picOutputStream() {
        try {
            OutputStream outputStream = new FileOutputStream("D:/tmp/img/test/thumb/12.png");
            Thumbnails.of(imgFile).scale(1.0f).outputFormat("png").toOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量操作图片
     */
    @Test
    public void batchImg() {
        try {
            File destinationDir = new File("D:/tmp/img/test/thumb");
            Thumbnails.of(imgFile1,imgFile2,imgFile3).scale(0.5f).toFiles(destinationDir, Rename.NO_CHANGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 BufferedImage 对象
     */
    @Test
    public void toBufferedImage() {
        try {
            BufferedImage bufferedImage = Thumbnails.of(imgFile).scale(1.0f).asBufferedImage();
            ImageIO.write(bufferedImage, "png", new File("D:/tmp/img/test/thumb/11.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片转换格式
     */
    @Test
    public void picFormat() {
        try {
            Thumbnails.of(imgFile).scale(1.0f).outputFormat("jpg").toFile("D:/tmp/img/test/thumb/10");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 裁剪图片（默认）
     */
    @Test
    public void picCutDefault() {
        try {
            Thumbnails.of(imgFile).scale(1.0f).sourceRegion(0, 0, 500, 900)
                    .toFile("D:/tmp/img/test/thumb/9.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 裁剪图片（中上区域）
     */
    @Test
    public void picCutTopCenter() {
        try {
            Thumbnails.of(imgFile).sourceRegion(Positions.TOP_CENTER, 200, 350)
                    .scale(1.0f).toFile("D:/tmp/img/test/thumb/8.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片裁剪（中间位置）
     */
    @Test
    public void picCutCenter() {
        try {
            Thumbnails.of(imgFile).sourceRegion(Positions.CENTER, 200, 350)
                    .scale(1.0f).toFile("D:/tmp/img/test/thumb/7.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给图片添加水印
     */
    @Test
    public void waterMark() {
        /**
         * watermark方法：
         * 第一个参数：水印图片位置
         * 第二个参数：水印图片
         * 第三个参数：水印图片透明度
         */
        try {
            Thumbnails.of(imgFile).scale(1.0f).watermark(Positions.TOP_RIGHT, ImageIO.read(new File("D:/tmp/img/test/thumb/3.png")), 0.8f)
                    .outputQuality(0.5).toFile("D:/tmp/img/test/thumb/6.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩图片大小
     */
    @Test
    public void outputQuality() {
        try {
            Thumbnails.of(imgFile).scale(1.0f).outputQuality(0.5).toFile("D:/tmp/img/test/thumb/5.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 旋转图片（顺时针）
     */
    @Test
    public void rotatePic() {
        try {
            Thumbnails.of(imgFile).scale(1.0f).rotate(90).toFile("D:/tmp/img/test/thumb/4.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定图片的大小（非等比）
     */
    @Test
    public void keepAspectRation() {
        try {
            Thumbnails.of(imgFile).size(200, 300).keepAspectRatio(false).toFile("D:/tmp/img/test/thumb/3.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照原图比例缩放图片
     */
    @Test
    public void scale() {
        try {
            Thumbnails.of(imgFile).scale(0.5f).toFile("D:/tmp/img/test/thumb/2.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照指定尺寸缩放图片（遵循原图片比例）
     */
    @Test
    public void size() {
        try {
            Thumbnails.of(imgFile).size(200, 350).toFile("D:/tmp/img/test/thumb/1.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
