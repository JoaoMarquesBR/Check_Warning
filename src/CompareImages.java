import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareImages {

    public boolean  compareImages() {
        BufferedImage errorScreenshot = null;
        BufferedImage screenShotTakenToBeCompare = null;

        try {

            File fileA = new File("C:\\CheckWarning_Software\\screenTaken.jpg");
            File fileB= new File("C:\\CheckWarning_Software\\screenError.jpg");

            errorScreenshot = ImageIO.read(fileA);
            screenShotTakenToBeCompare = ImageIO.read(fileB);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width1 = errorScreenshot.getWidth();
        int width2 = screenShotTakenToBeCompare.getWidth();
        int height1 = errorScreenshot.getHeight();
        int height2 = screenShotTakenToBeCompare.getHeight();

        if ((width1 != width2) || (height1 != height2))

            System.out.println("Error: Images dimensions"
                    + " mismatch");
        else {

            long difference = 0;

            for (int y = 0; y < height1; y++) {

                for (int x = 0; x < width1; x++) {

                    int rgbA = errorScreenshot.getRGB(x, y);
                    int rgbB = screenShotTakenToBeCompare.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;

                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }

        }
        if ((width1 != width2) || (height1 != height2))

            System.out.println("Error: Images dimensions"
                    + " mismatch");
        else {


            long difference = 0;

            for (int y = 0; y < height1; y++) {

                for (int x = 0; x < width1; x++) {

                    int rgbA = errorScreenshot.getRGB(x, y);
                    int rgbB = screenShotTakenToBeCompare.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA)&0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB)&0xff;

                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }

            double total_pixels = width1 * height1 * 3;

            double avg_different_pixels
                    = difference / total_pixels;

            double percentage
                    = (avg_different_pixels / 255) * 100;

            System.out.println("Difference Percentage--> "+ percentage);

            if(percentage < 12){
                System.out.println("Image is similar!! let's troubleshoot it");
                return true;
            }else{
                return false;
            }

        }
        return false;
    }
}
