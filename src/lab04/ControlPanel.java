package lab04;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel {
    
    private StickFigure stickman;
    private JButton rightButton, leftButton, toggleButton, colorButton;
    private JCheckBox noseCheckBox, eyesCheckBox, mouthCheckBox;
    private JSlider heightSlider;
    
    public ControlPanel(StickFigure stickman) {
        this.stickman = stickman;
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        toggleButton = new JButton("Toggle Animation");
        toggleButton.addActionListener(new ToggleListener());
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        add(toggleButton, c);

        rightButton = new JButton("Move Right");
        rightButton.addActionListener(new RightListener());
        c.gridx = 1;
        c.gridy = 1;
        add(rightButton, c);

        leftButton = new JButton("Move Left");
        leftButton.addActionListener(new LeftListener());
        c.gridx = 1;
        c.gridy = 2;
        add(leftButton, c);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        eyesCheckBox = new JCheckBox("Eyes", true);
        eyesCheckBox.addActionListener(new EyesListener());
        checkBoxPanel.add(eyesCheckBox);
        noseCheckBox = new JCheckBox("Nose", true);
        noseCheckBox.addActionListener(new NoseListener());
        checkBoxPanel.add(noseCheckBox);
        mouthCheckBox = new JCheckBox("Mouth", true);
        mouthCheckBox.addActionListener(new MouthListener());
        checkBoxPanel.add(mouthCheckBox);
        checkBoxPanel.setBorder(new TitledBorder(new EtchedBorder(), "Visibility"));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        add(checkBoxPanel, c);

        heightSlider = new JSlider(JSlider.VERTICAL, stickman.height/3, stickman.bottomY, stickman.height);
        heightSlider.addChangeListener(new HeightListener());
        heightSlider.setPaintLabels(true);
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(20, 5, 20, 5);
        c.weightx = 0.5;
        c.gridheight = 3;
        c.fill = GridBagConstraints.VERTICAL;
        add(heightSlider, c);
        
        colorButton = new JButton();
        colorButton.setBackground(stickman.color);
        colorButton.addActionListener(new ColorListener());
        Dimension d = new Dimension(40,40);
        colorButton.setPreferredSize(d);
        colorButton.setMinimumSize(d);
        colorButton.setMaximumSize(d);
        c.gridx = 3;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.insets = new Insets(10,10,10,10);
        c.gridheight = 1;
        add(colorButton, c);

        setMaximumSize(new Dimension(500, 200));
        setPreferredSize(new Dimension(400, 150));
        
    }

    class ToggleListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (stickman.timer.isRunning()) stickman.timer.stop();
            else stickman.timer.start();
        }
        
    }

    class RightListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            stickman.direction = 1;
            stickman.timer.start();
        }
        
    }

    class LeftListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            stickman.direction = -1;
            stickman.timer.start();
        }
        
    }

    class EyesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (eyesCheckBox.isSelected()) {
                stickman.eyesVisible = true;
            }
            else {
                stickman.eyesVisible = false;
            }
            stickman.repaint();
        }
        
    }

    class NoseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (noseCheckBox.isSelected()) {
                stickman.noseVisible = true;
            }
            else {
                stickman.noseVisible = false;
            }
            stickman.repaint();
        }
        
    }

    class MouthListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (mouthCheckBox.isSelected()) {
                stickman.mouthVisible = true;
            }
            else {
                stickman.mouthVisible = false;
            }
            stickman.repaint();
        }
        
    }

    class HeightListener implements ChangeListener {

        public void stateChanged(ChangeEvent e) {
            stickman.setHeight(heightSlider.getValue());
            stickman.repaint();
        }
        
    }

    class ColorListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            Color c = JColorChooser.showDialog(new JFrame(), "Pick a color", stickman.color);
            if (c != null) {
                stickman.color = c;
                colorButton.setBackground(c);
                stickman.repaint();
            }
        }
        
    }
    
}
