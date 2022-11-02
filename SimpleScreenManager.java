package scene;

import javax.swing.*;
import java.awt.*;

public class SimpleScreenManager {

    private GraphicsDevice device;

    // Creates a SimpleScreenManager Object.
    public SimpleScreenManager(){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = environment.getDefaultScreenDevice();
    }

    // Enters full screen mode and changes the display mode.
    public void setFullScreen(DisplayMode displayMode, JFrame window){
        window.setUndecorated(true);
        window.setResizable(false);

        device.setFullScreenWindow(window);
        if (displayMode != null && device.isDisplayChangeSupported()) {
            try {
                device.setDisplayMode(displayMode);
            }
            catch (IllegalArgumentException ex){
                // ignore - illegal mode for this device
            }
        }
    }

    public Window getFullScreenWindow() {
        return device.getFullScreenWindow();
    }

    // Restores the screen's display mode.
    public void restoreScreen(){
        Window window = device.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        device.setFullScreenWindow(null);
    }

}
