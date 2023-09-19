/**
 * Window that allows you to pick the drawMode and fill for the DrawPanel
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

public class ShapeOptions extends JFrame implements ActionListener
{
    private JButton fill;
    private JButton outline;

    public ShapeOptions()
    {
        super("Shape Tool Options");
        this.setLayout(new FlowLayout());
        this.setSize(300, 70 );
        
        this.add(new JLabel("Fill/Outline Mode"));

        fill = new JButton(" Fill ");
        fill.setBorder(BorderFactory.createRaisedBevelBorder());
        fill.setBackground(new Color(216, 223, 234));
        fill.addActionListener(this);
        this.add(fill);

        outline = new JButton(" Outline ");
        outline.setBorder(BorderFactory.createRaisedBevelBorder());
        outline.setBackground(new Color(216, 223, 234));
        outline.addActionListener(this);
        this.add(outline);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(fill))
        {DrawPanel.FILLMODE = true;}

        else
        {DrawPanel.FILLMODE = false;}

        this.dispose();
    }
}
