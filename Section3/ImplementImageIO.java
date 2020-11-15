package ImageReader;

import imagereader.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.*;
import java.awt.color.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class ImplementImageIO implements IImageIO
{
	private int bitCount = 0;
     
    public Image myRead(String filePath) {
    	try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
            bis.skip(18);
            
            byte[] tmpw = new byte[4];
            byte[] tmph = new byte[4];
            bis.read(tmpw);
            bis.read(tmph);
            int width = byteToInt(tmpw);
            int height = byteToInt(tmph);
            bis.skip(2);
            
            bitCount = (int)(bis.read() | (bis.read() << 8));
            int skipNum = (bitCount * width / 8) % 4;
            if (skipNum != 0)
            	skipNum = 4-skipNum; 
            bis.skip(24);
            
            if (bitCount == 24) {
            	int[] data = new int[height * width]; 
            	for (int i = height - 1; i >= 0; i--) {
            		for (int j = 0; j < width; j++) {
            			int blue = bis.read();
            			int green = bis.read();
            			int red = bis.read();
            			Color c = new Color(red, green, blue);
            			data[i * width + j] = c.getRGB();
            		}	
            		if (skipNum != 0)
            			bis.skip(skipNum);
            	}
            	return Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(width, height, data, 0, width));

            } else if (bitCount == 8) {
            	bis.skip(1024);
            	int[] data = new int[height * width]; 
            	for (int i = height - 1; i >= 0; i--) {
            		for (int j = 0; j < width; j++) {
            			int rgb = bis.read();
            			Color c = new Color(rgb, rgb, rgb);
            			data[i*width+j] = c.getRGB();
            		}

            		if (skipNum != 0)
            			bis.skip(skipNum);
            	}
            	return Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(width, height, data, 0, width));

            } else {
            	return null;
            }
            
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }

    public int byteToInt(byte[] b) {
    	 int b0 = b[0] & 0xff;
    	 int b1 = b[1] & 0xff;
    	 int b2 = b[2] & 0xff;
    	 int b3 = b[3] & 0xff;
    	 int res =  b3 << 24 | b2 << 16 | b1 << 8 | b0;
    	 return res;
    }

    public Image myWrite(Image image, String filePath) {   
        try {
            BufferedImage bimage;
            if (bitCount == 8) {
            	bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
            } else {
            	bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            }
            Graphics2D g = bimage.createGraphics();
            g.drawImage(image, null, null);
            ImageIO.write(bimage, "bmp", new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
