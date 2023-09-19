/**
 * Window that pops up to allow you to pick to draw shapes or lines
 * 
 * @author Rachel Hu
 * @version v2 (June 3, 2021)
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.awt.FlowLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawModeOptions extends JFrame implements ActionListener
{
    private JButton line;
    private JButton oval;
    private JButton rectangle;

    public DrawModeOptions()
    {
        super("Drawing Mode Options");
        this.setLayout(new FlowLayout());
        this.setSize(240, 70);

        this.add(new JLabel("Mode: "));
       
        line = new JButton(" Line ");
        line.setBorder(BorderFactory.createRaisedBevelBorder());
        line.setBackground(new Color(216, 223, 234));
        line.addActionListener(this);
        this.add(line);
       
        oval = new JButton(" Oval ");
        oval.setBorder(BorderFactory.createRaisedBevelBorder());
        oval.setBackground(new Color(216, 223, 234));
        oval.addActionListener(this);
        this.add(oval);

        rectangle = new JButton(" Rectangle ");
        rectangle.setBorder(BorderFactory.createRaisedBevelBorder());
        rectangle.setBackground(new Color(216, 223, 234));
        rectangle.addActionListener(this);
        this.add(rectangle);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(line))
        {DrawPanel.SHAPEMODE = 1;}

        else if (e.getSource().equals(oval))
        {DrawPanel.SHAPEMODE = 2;}

        else if (e.getSource().equals(rectangle))
        {DrawPanel.SHAPEMODE = 4;}

        this.dispose();
    }
    
}
