package lab04;

import java.awt.Color;

import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        StickFigure sf = new StickFigure(300, 400, Color.ORANGE, 400);
        ControlPanel cp = new ControlPanel(sf);
        frame.add(cp, BorderLayout.SOUTH);
        frame.add(sf);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
