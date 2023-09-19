 /**
 * Main class for running the program (experiments)
 *
 * @author Rachel Hu
 * @version May 22, 2021/May 20, 2021
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class TestingStuff
{
    public static void main(String[] args)
    {
        //makes the window that pops up
        JFrame window = new JFrame("window");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        //sets the layout of the window for stuff to go in
        BorderLayout template = new BorderLayout();
        window.setLayout(template);
        
        //adds some text in a label in the top left corner of the layout of the window
        JLabel text = new JLabel("wow so cool what am I doing");
        text.setAlignmentX(500);
        text.setAlignmentY(700);
        //System.out.println(text.getText());
        window.add(text, BorderLayout.BEFORE_FIRST_LINE);
        
        //creates a frame in the center of the window
        JPanel area = new JPanel();
        area.setName("drawing area");
        area.setSize(400, 400);
        area.setBackground(new Color(52, 229, 235));
        area.setVisible(true);
        window.add(area, BorderLayout.CENTER);
                
        //area.addMouseMotionListener();
    }
}
