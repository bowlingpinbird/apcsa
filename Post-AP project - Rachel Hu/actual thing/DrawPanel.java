/**
 * Panel to be used in the ArtWindow that lets you draw in it
 *
 * @author Rachel Hu
 * @version v10 (June 8, 2021)
 */

import javax.swing.JPanel;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener
{    
    private Graphics graphics;
    public static Color COLOR = new Color(0,0,0); //COLOR is the current COLOR that graphics will use to draw on the DrawPanel
    public static Color OLD_COLOR = new Color(0,0,0); //use for color history in the ArtWindow
    public static Color EXTRA_OLD_COLOR = new Color(0,0,0);
    public static Color EXTREMELY_OLD_COLOR = new Color(0,0,0);

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int initialX;
    private int initialY;
    
    public static int SYMMNUM = 1; //SYMMNUM is used to help with doing rotational symmetry, the number represents the number of 'rotations' (default is no symmetry, and it can be 1, 2, or 4)
    public static int SHAPEMODE = 1; //SHAPEMODE is used to help with the drawing mode (default 1 = lines, 2 = ovals, 4 = rectangles)
    public static boolean FILLMODE = true; //fill is used to help with whether to fill when a shape is drawn, default: true = it will be filled
    public static int STAMPMODE = 1; //sets the stamp mode, or how the stuff is drawn in line mode (defalt 1 = lines, 2 = ovals, 4 = rectangles)
    public static int THICKNESS = 1; //size of the stamps, 0 = weird glitchy cool size, 1 is default

    public DrawPanel()
    {
        super();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setBackground(new Color(255, 255, 255));
        
        this.setLayout(new BorderLayout());
        
        this.setVisible(true);
    }
   
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        graphics = this.getGraphics();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (!DrawPanel.COLOR.equals(graphics.getColor()))
        {graphics.setColor(DrawPanel.COLOR);}
        
        startX = e.getX();
        initialX = e.getX();
        startY = e.getY();
        initialY = e.getY();
    }
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        endX = e.getX();
        endY = e.getY();
        
        if (SHAPEMODE == 1) //checks if it's on line drawing mode or shape mode
        {
            if (STAMPMODE == 1)
            {
                graphics.drawLine(startX, startY, endX, endY);
                graphics.drawLine(startX+1, startY, endX+1, endY);
                graphics.drawLine(startX-1, startY, endX-1, endY);

                if (SYMMNUM != 1) // checks to see if it needs to do rotational symmetry
                {
                    if (SYMMNUM == 2 || SYMMNUM == 4) // rotational symmetry, rotated 180 degrees
                    {
                        graphics.drawLine(this.getWidth() - startX, this.getHeight() - startY, this.getWidth() - endX, this.getHeight() - endY);
                        graphics.drawLine(this.getWidth() - startX +1, this.getHeight() - startY, this.getWidth() - endX+1, this.getHeight() - endY);
                        graphics.drawLine(this.getWidth() - startX -1, this.getHeight() - startY, this.getWidth() - endX-1, this.getHeight() - endY);
                    }

                    if (SYMMNUM == 4) // rotation symmetry, rotated 90 degrees 4 times
                    {
                        graphics.drawLine(this.getHeight() - startY, startX, this.getHeight() - endY, endX);
                        graphics.drawLine(this.getHeight() - startY+1, startX, this.getHeight() - endY+1, endX);
                        graphics.drawLine(this.getHeight() - startY-1, startX, this.getHeight() - endY-1, endX);

                        graphics.drawLine(startY, this.getWidth() - startX, endY, this.getWidth() - endX);
                        graphics.drawLine(startY+1, this.getWidth() - startX, endY+1, this.getWidth() - endX);
                        graphics.drawLine(startY-1, this.getWidth() - startX, endY-1, this.getWidth() - endX);
                    }
                }
            }
            else if (STAMPMODE == 2)
            {
                if (THICKNESS == 0)
                {graphics.drawOval(startX, startY, endX, endY);}

                else
                {graphics.drawOval(startX, startY, THICKNESS, THICKNESS);}
            }
            else if (STAMPMODE == 4)
            {
                if (THICKNESS == 0)
                {graphics.drawRect(startX, startY, endX, endY);}

                else
                {graphics.drawRect(startX, startY, THICKNESS, THICKNESS);}
            }
        }
        startX = endX;
        startY = endY;
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (SHAPEMODE == 2) //ovals
        {
            if (FILLMODE)
            {graphics.fillOval(initialX, initialY, e.getX()-initialX, e.getY()-initialY);}
            else
            {graphics.drawOval(initialX, initialY, e.getX()-initialX, e.getY()-initialY);}
        }
        if (SHAPEMODE == 4) //rectangles
        {
            if (FILLMODE)
            {graphics.fillRect(initialX, initialY, e.getX()-initialX, e.getY()-initialY);}
            else
            {graphics.drawRect(initialX, initialY, e.getX()-initialX, e.getY()-initialY);}
        }
    }

    public void clear()
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(COLOR);
    }

    public static void setColor(Color c)
    { //could have probably used a loop and put them in an array but ehhhhhhhhhhhhhhhhhhhhhh can't be bothered
        EXTREMELY_OLD_COLOR = EXTRA_OLD_COLOR;
        EXTRA_OLD_COLOR = OLD_COLOR;
        OLD_COLOR = COLOR;
        COLOR = c;
    }
    



    //extra stuff that needs to be overridden for the interface to work
    @Override
    public void mouseClicked(MouseEvent e){}
    
    @Override
    public void mouseMoved(MouseEvent e){}
    
    @Override
    public void mouseExited(MouseEvent e){}
    
    @Override
    public void mouseEntered(MouseEvent e){}
}