// Author  : Joao Marques
//   Date  : March 14, 2022
// Purpose : Troubleshoot Machine of The Factory

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;

public class Check {

    private boolean idle=false;
    private static int lastMouseX = 0;
    private static int lastMouseY =0;
    private static int timeDurationForChecks = 1000;
    private static int counterTroubleshoot=0;

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        System.out.println("RedScreen TroubleShooter - Verion 3.1.0");
        System.out.println("Made By - Joao Marques");
        KeepTrack.start();//keep track must be started before.
        //important for keeping data of how many times we've troubleshooted.

        Robot myRobot = new Robot();
        int counter=0;

        CompareImages compareImages  = new CompareImages();
        while (true){
            Thread.sleep(timeDurationForChecks);
            //needs to have a RED screen AND mouse idle for 5s.
            System.out.println("Machine has troubleshooted "+counterTroubleshoot +" times.");
            screenShot();
            if(compareImages.compareImages()){
                //press mouse to make sure to put the app in top layout.
                for(int i=0;i<2;i++){
                    myRobot.mouseMove(2,2);
                    myRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                     Thread.sleep(100);
                     myRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                     Thread.sleep(100);
                    }

                //double check application in top layer
                for(int i=0;i<2;i++){
                    myRobot.keyPress(KeyEvent.VK_ALT);
                    Thread.sleep(130);
                    myRobot.keyPress(KeyEvent.VK_TAB);
                    Thread.sleep(130);
                    myRobot.keyRelease(KeyEvent.VK_TAB);
                    myRobot.keyRelease(KeyEvent.VK_ALT);
                    Thread.sleep(130);
                }

                //close application
                myRobot.keyPress(KeyEvent.VK_ALT);
                myRobot.keyPress(KeyEvent.VK_F4);
                Thread.sleep(130);
                myRobot.keyRelease(KeyEvent.VK_ALT);
                myRobot.keyRelease(KeyEvent.VK_F4);
                Thread.sleep(130);

                myRobot.mouseMove(2,2);
                Thread.sleep(30);
                for(int i=0;i<2;i++){
                    myRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    Thread.sleep(130);
                    myRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    Thread.sleep(130);
                }

                //check if screen was solved.
                //in case of false, troubleshoot worked perfectly.
                screenShot();
                if(!compareImages.compareImages()){
                    counterTroubleshoot++;
                    KeepTrack.printTroubleshoot();
                    System.out.println("\nTroubleshoot was done..");
                    break;
                }

            }else{
                System.out.println("All good.");
            }

        }
    }


    private static int getMouseX() throws AWTException {
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        //System.out.print("Mouse Location X,Y (" + mouseX);
        return ((int) mouseX);
    }
    private static  int getMouseY() throws AWTException {
        double mouseY = MouseInfo.getPointerInfo().getLocation().getX();
        //  System.out.print(", " + mouseY+")\n");
        return ((int) mouseY);
    }

    private static boolean checkIdle() throws AWTException {
        int x= getMouseX();
        int y= getMouseX();
        if(x!= lastMouseX && y!=lastMouseY ){
             lastMouseX = x;
            lastMouseY = y;
            return false;
        }else{
            return true;
        }
    }

     private static void screenShot() throws IOException, AWTException {
        int width=0;
        int height=0;
        try {
            Thread.sleep(120);
            Robot r = new Robot();
            // It saves screenshot to desired path
            String path = "C:\\CheckWarning_Software\\screenTaken.jpg";
            // Used to get ScreenSize and capture image
            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bfImage = r.createScreenCapture(capture);
            ImageIO.write(bfImage, "jpg", new File(path));
            width = bfImage.getWidth();
            height = bfImage.getHeight();
        }
        catch (AWTException | IOException | InterruptedException ex) {
            System.out.println(ex);
            System.out.println("Error message");
        }
    }

    //takes the screenshoot of the error and saves it.
    private static void screenShotError() throws IOException, AWTException {
        int width=0;
        int height=0;
        try {
            Thread.sleep(120);
            Robot r = new Robot();
            // It saves screenshot to desired path
            String path = "C:\\CheckWarning_Software\\screenErrorOriginalTaken.jpg";
            // Used to get ScreenSize and capture image
            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bfImage = r.createScreenCapture(capture);
            ImageIO.write(bfImage, "jpg", new File(path));
            width = bfImage.getWidth();
            height = bfImage.getHeight();
        }
        catch (AWTException | IOException | InterruptedException ex) {
            System.out.println(ex);
            System.out.println("Error message");
        }
    }


}
