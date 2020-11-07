package IR;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.awt.Image;
import javax.imageio.ImageIO;


public class IRTest {

	
  private String filepathOne ="D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\1.bmp";
  private String filepathRedOne = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\1_red_goal.bmp";
  private String filepathGreenOne = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\1_green_goal.bmp";
  private String filepathBlueOne = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\1_blue_goal.bmp";
  private String filepathGrayOne = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\1_gray_goal.bmp";


  private String filepathTwo = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\2.bmp";
  private String filepathRedTwo ="D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\2_red_goal.bmp";
  private String filepathGreenTwo = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\2_green_goal.bmp";
  private String filepathBlueTwo = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\2_blue_goal.bmp";
  private String filepathGrayTwo = "D:\\Documents\\Work\\大三上学期\\中级实训\\Section3\\bmptest\\goal\\2_gray_goal.bmp";


  @Test
  /* Test Red */
  public void testRedOne() {
    compare(filepathRedOne, filepathOne, 1);
  }

  @Test
  /* Test Green */
  public void testGreenOne() {
    compare(filepathGreenOne, filepathOne, 2);
  }

  @Test
  /* Test Blue */
  public void testBlueOne() {
    compare(filepathBlueOne, filepathOne, 3);
  }

  @Test
  /* Test Gray */
  public void testGrayOne() {
    compare(filepathGrayOne, filepathOne, 4);
  }


  @Test
  /* Test Red */
  public void testRedTwo() {
    compare(filepathRedTwo, filepathTwo, 1);
  }

  @Test
  /* Test Green */
  public void testGreenTwo() {
    compare(filepathGreenTwo, filepathTwo, 2);
  }

  @Test
  /* Test Blue */
  public void testBlueTwo() {
    compare(filepathBlueTwo, filepathTwo, 3);
    
  }

  @Test
  /* Test Gray */
  public void testGrayTwo() {
      compare(filepathGrayTwo, filepathTwo, 4);
  }

  /* Auxilary funtion to test gray */
  private void compare(String path1, String path2, int type) {
    try {
      // Standared Answer
      FileInputStream inputstream = new FileInputStream(path1);
      BufferedImage answer = ImageIO.read(inputstream);

      // Answer
      IMImageIO input = new IMImageIO();
      Image image = input.myRead(path2);

      // Processor
      ImplementImageProcessor myProcessor = new ImplementImageProcessor();
      Image myImage = null;
      if (type == 1) {
        myImage = myProcessor.showChanelR(image);
      }
      else if (type == 2) {
        myImage = myProcessor.showChanelG(image);
      }
      else if (type == 3) {
        myImage = myProcessor.showChanelB(image);
      }
      else if (type == 4) {
        myImage = myProcessor.showGray(image);
      }
      

      // Compare the size of the picture
      assertEquals(myImage.getHeight(null), answer.getHeight(null));
      assertEquals(myImage.getWidth(null), answer.getWidth(null));

      // Compare every pixel in the picture
      BufferedImage my = new BufferedImage(myImage.getWidth(null), myImage.getHeight(null), BufferedImage.TYPE_INT_RGB);  
      my.getGraphics().drawImage(myImage, 0, 0,null);
      for (int y = 0; y < answer.getHeight(); y++) {
        for (int x = 0; x < answer.getWidth(); x++) {  
          assertEquals(my.getRGB(x, y), answer.getRGB(x, y));
        }
      }
    }
    catch (Exception ex) {

    }
  }

}