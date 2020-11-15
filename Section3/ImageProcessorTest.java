package ImageReader;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.awt.Image;
import javax.imageio.ImageIO;


public class IRTest {


   private String filepathOne ="D:\\bmptest\\1.bmp";
   private String filepathRedOne = "D:\\bmptest\\1_red.bmp";
   private String filepathGreenOne = "D:\\bmptest\\1_green.bmp";
   private String filepathBlueOne = "D:\\bmptest\\1_blue.bmp";
   private String filepathGrayOne = "D:\\bmptest\\1_gray.bmp";


   private String filepathTwo = "D:\\bmptest\\2.bmp";
   private String filepathRedTwo ="D:\\bmptest\\2_red_goal.bmp";
   private String filepathGreenTwo = "D:\\bmptest\\2_green.bmp";
   private String filepathBlueTwo = "D:\\bmptest\\2_blue.bmp";
   private String filepathGrayTwo = "D:\\bmptest\\2_gray.bmp";


   @Test
   public void testRedOne() {
	   compare(filepathRedOne, filepathOne, 1);
   }

   @Test
   public void testGreenOne() {
	   compare(filepathGreenOne, filepathOne, 2);
   }

   @Test
   public void testBlueOne() {
	   compare(filepathBlueOne, filepathOne, 3);
   }

   @Test
   public void testGrayOne() {
	   compare(filepathGrayOne, filepathOne, 4);
   }


   @Test
   public void testRedTwo() {
	   compare(filepathRedTwo, filepathTwo, 1);
   }

   @Test
   public void testGreenTwo() {
	   compare(filepathGreenTwo, filepathTwo, 2);
   }

   @Test
   public void testBlueTwo() {
	   compare(filepathBlueTwo, filepathTwo, 3);   
   }

   @Test
   public void testGrayTwo() {
	   compare(filepathGrayTwo, filepathTwo, 4);
   }

   private void compare(String path1, String path2, int num) {
	   try {

		   FileInputStream inputstream = new FileInputStream(path1);
		   BufferedImage answer = ImageIO.read(inputstream);

		   ImplementImageIO input = new ImplementImageIO();
		   Image image = input.myRead(path2);

		   ImplementImageProcessor myProcessor = new ImplementImageProcessor();
		   Image myImage = null;
		   if (num == 1) {
			   myImage = myProcessor.showChanelR(image);
		   } else if (num == 2) {
			   myImage = myProcessor.showChanelG(image);
		   } else if (num == 3) {
			   myImage = myProcessor.showChanelB(image);
		   } else if (num == 4) {
			   myImage = myProcessor.showGray(image);
		   }
      
		   assertEquals(myImage.getHeight(null), answer.getHeight(null));
		   assertEquals(myImage.getWidth(null), answer.getWidth(null));

		   BufferedImage my = new BufferedImage(myImage.getWidth(null), myImage.getHeight(null), BufferedImage.TYPE_INT_RGB);  
		   my.getGraphics().drawImage(myImage, 0, 0,null);
		   for (int y = 0; y < answer.getHeight(); y++) {
			   for (int x = 0; x < answer.getWidth(); x++) {  
				   assertEquals(my.getRGB(x, y), answer.getRGB(x, y));
			   }
		   }
	   }
	   catch (Exception ex) {}
   }

}