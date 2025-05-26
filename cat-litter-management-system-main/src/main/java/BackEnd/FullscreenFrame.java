/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import javax.swing.*;
import java.awt.*;

public class FullscreenFrame extends JFrame {
    public FullscreenFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true); // Removes title bar and borders
        setResizable(false);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            System.out.println("Fullscreen not supported. Maximizing instead.");
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FullscreenFrame();
    }
}
