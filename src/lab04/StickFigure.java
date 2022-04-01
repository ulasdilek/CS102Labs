package lab04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StickFigure extends JPanel{
    //a stick figure with head, eyes, nose, mouth, backbone, arms, legs

    int centerX, bottomY, x, y, width, height, direction, headDiameter, headX, armStartY, legStartY, halfWidth;
    double headRatio;
    boolean eyesVisible, noseVisible, mouthVisible;
    Color color;
    Timer timer;
    BasicStroke stroke;

    public StickFigure(int baseX, int baseY, Color color, int size) {
        this.color = Color.black;
        stroke = new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        direction = 1; // 1 for right, -1 for left
        eyesVisible = true;
        noseVisible = true;
        mouthVisible = true;
        centerX = baseX;
        bottomY = baseY;
        height = size;
        width = height / 3;
        setX(centerX);
        setY(bottomY);
        setBackground(color);
        setPreferredSize(new Dimension(centerX*2, height + y * 2));
        halfWidth = width / 2;
        headRatio = 12.0 / 15;
        headDiameter = (int) (width * headRatio);
        headX = x + (int) (( 1 - headRatio) * halfWidth);
        armStartY = y + height / 3;
        legStartY = baseY - halfWidth;
        timer = new Timer(18, new TimerListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(color);
        g2.setStroke(stroke);

        int partitionX = headDiameter / 9;
        int partitionY = headDiameter / 5;
        drawHead(g2);
        if (eyesVisible) {
            drawEyes(g2, partitionX, partitionY);
        }
        if (noseVisible) {
            drawNose(g2, partitionX, partitionY);
        }
        if (mouthVisible) {
            drawMouth(g2, partitionX, partitionY);
        }

        g2.drawLine(centerX, y + headDiameter, centerX, legStartY); // backbone
        g2.drawLine(centerX, armStartY, centerX - halfWidth, armStartY + halfWidth); // left arm
        g2.drawLine(centerX, armStartY, centerX + halfWidth, armStartY + halfWidth); // right arm
        g2.drawLine(centerX, legStartY, centerX - halfWidth, legStartY + halfWidth); // left leg
        g2.drawLine(centerX, legStartY, centerX + halfWidth, legStartY + halfWidth); // right leg

        // Bounding boxes
        // g2.setColor(Color.white);
        // g2.setStroke(new BasicStroke(1.0f));
        // g2.drawRect(x, y, width, height);
        // g2.drawRect(headX, y, headDiameter, headDiameter);

    }
    
    public void transform(int dx, int dy) {
        Dimension panelSize = getSize();
        if (x + width >= panelSize.width) {
            dx = - panelSize.width + width;
        }
        if (x < 0) {
            dx = panelSize.width - width;
        }
        x += dx;
        y += dy;
        centerX += dx;
        bottomY += dy;
        headX += dx;
        armStartY += dy;
        legStartY += dy;
    }

    public void setX(int x) {
        this.x = x - width/2;
    }

    public void setY(int y) {
        this.y = y - height;
    }

    public void setHeight(int height) {
        this.height = height;
        width = this.height / 3;
        halfWidth = width / 2;
        setX(centerX);
        setY(bottomY);
        headDiameter = (int) (width * headRatio);
        headX = x + (int) (( 1 - headRatio) * halfWidth);
        armStartY = y + height / 3;
        legStartY = bottomY - halfWidth;
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            transform(direction, 0);
            repaint();
        }
    }

    private void drawHead(Graphics2D g2) {
        g2.drawOval(headX, y, headDiameter, headDiameter); //head
    }

    private void drawEyes(Graphics2D g2, int partitionX, int partitionY){
        int eyeX = headX + 2*partitionX;
        int eyeY = y + partitionY;
        g2.drawOval(eyeX, eyeY, 2 * partitionX, partitionY); // left eye
        g2.drawOval(eyeX + 3 * partitionX, eyeY, 2 * partitionX, partitionY); // right eye
    }

    private void drawNose(Graphics2D g2, int partitionX, int partitionY){
        int noseY = y + 2*partitionY;
        g2.drawLine(centerX, noseY, centerX, noseY + partitionY); // nose
    }

    private void drawMouth(Graphics2D g2, int partitionX, int partitionY){
        int mouthX = headX + 3 * partitionX;
        int mouthY = y + 3 * partitionY;
        g2.drawPolygon(new int[] {mouthX, mouthX + 3 * partitionX, centerX}, new int[] {mouthY, mouthY, mouthY + partitionY}, 3); // mouth
    }
    
}
