import java.awt.*;
import java.awt.MouseInfo;

public class MouseInformation {

    public int getMouseX() throws AWTException {
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        //System.out.print("Mouse Location X,Y (" + mouseX);
        return ((int) mouseX);
    }
    public int getMouseY() throws AWTException {
        double mouseY = MouseInfo.getPointerInfo().getLocation().getX();
      //  System.out.print(", " + mouseY+")\n");
        return ((int) mouseY);
    }
}
