package IR;
import imagereader.Runner;
public class ImageReaderRunner 
{
      public static void main(String[] args) {
           IMImageIO imageioer = new IMImageIO();
           ImplementImageProcessor processor = new ImplementImageProcessor();
           Runner.run(imageioer, processor);
      }
}