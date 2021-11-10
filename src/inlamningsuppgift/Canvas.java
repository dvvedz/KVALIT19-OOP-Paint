package inlamningsuppgift;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * This is the Canvas class, this class is used for drawing graphics to the JFrame.
 *
 */

public class Canvas extends JPanel {

    int brush;
    Color color;

    /**
     *
     * this is the constructor of Canvas,
     * it initialize some default values for the brush and color when the program just start.
     *
     */

    Canvas(){
        this.brush = 10;
        this.color = Color.BLACK;
    }

    /**
     *
     * this method can change the program background color and start screen.
     * if the paintComponent is updated it will delete everything in JPanel and then draw again.
     * In this case if paintComponent is ran again it will remove all the drawed circles and give us a clean white panel.
     *
     * @param g contains Graphics
     *
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
    }

    /**
     *
     * This method detects if mouse is pressed and if it's pressed it will draw a circle to the JFrame.
     *
     */

    void mousePressed() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Graphics g = getGraphics();
                g.setColor(color);
                g.fillOval(e.getX() - brush / 2 ,e.getY() - brush / 2, brush, brush);
           }
        });
    }

    /**
     *
     * This method if called,
     * will draw a circle to the JFrame and continue drawing circles as long as the mouse is clicked
     *
     */
    void mouseDragged() {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Graphics g = getGraphics();
                g.setColor(color);
                g.fillOval(e.getX() - brush / 2 , e.getY() - brush / 2, brush, brush);
            }
        });
    }
}
