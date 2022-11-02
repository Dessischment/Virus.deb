package test;

import scene.SimpleScreenManager;

import javax.swing.*;
import java.awt.*;

public class FullScreenTest extends JFrame {

    public static void main(String[] args) {

        DisplayMode displayMode;

        if (args.length == 3) {
            displayMode = new DisplayMode(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), DisplayMode.REFRESH_RATE_UNKNOWN);
        }

        else {
            displayMode = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        }

        FullScreenTest test = new FullScreenTest();
        test.run(displayMode);

    }

    private static final long DEMO_TIME = 5000;

    public void run(DisplayMode displayMode){
        setBackground(Color.white);
        setForeground(Color.black);
        setFont(new Font("Dialog", Font.PLAIN, 24));

        SimpleScreenManager screen = new SimpleScreenManager();
        try {
            screen.setFullScreen(displayMode, this);
            try {
                Thread.sleep(DEMO_TIME);
            }
            catch (InterruptedException ex) { }
        }
        finally {
            screen.restoreScreen();
        }
    }

    public void paint(Graphics g){
        g.drawString("Hello!", 20, 50);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }

        g.drawString("I", 20, 100);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        g.drawString("like", 20, 150);

        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){}
        g.drawString("TUNA!", 100, 150);

        try {
            Thread.sleep(500);
        }catch (InterruptedException ex){}
        g.drawString("TUNA!", 130, 170);

        for (int i = 0; i < 50; i++){
            for (int i2 = 0; i2 < 30; i2++){
                try {
                    Thread.sleep(10);
                }catch (InterruptedException ex) { }
                g.drawString("TUNA!", (i2 + 20) * 4, (i2 + 20) * 4);
            }
        }

    }

}
