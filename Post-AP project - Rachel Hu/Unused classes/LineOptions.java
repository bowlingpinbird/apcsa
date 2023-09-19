
/**
 * A window that allows you to pick how you want your drawing to be mirror w/ rotational symmetry
 *
 * @author Rachel Hu
 * @version v4 (June 3, 2021)
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

import java.awt.FlowLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineOptions extends JFrame implements ActionListener
{
    private JButton oneWay;
    private JButton twoWay;
    private JButton fourWay;

    private JButton rectStamp;
    private JButton ovalStamp;

    private JTextField stampSize;
    private int size;

    public LineOptions()
    {
        super("Line Tool Options");
        this.setSize(500, 90);
        this.setLayout(new FlowLayout());

        this.add(new JLabel("Rotational Symmetry (only applies to default LINE mode w/o stamps"));
        
        oneWay = new JButton("  1  ");
        oneWay.setBorder(BorderFactory.createRaisedBevelBorder());
        oneWay.setBackground(new Color(216, 223, 234));
        oneWay.addActionListener(this);
        this.add(oneWay);
        
        twoWay = new JButton("  2  ");
        twoWay.setBorder(BorderFactory.createRaisedBevelBorder());
        twoWay.setBackground(new Color(216, 223, 234));
        twoWay.addActionListener(this);
        this.add(twoWay);
        
        fourWay = new JButton("  4  ");
        fourWay.setBorder(BorderFactory.createRaisedBevelBorder());
        fourWay.setBackground(new Color(216, 223, 234));
        fourWay.addActionListener(this);
        this.add(fourWay);
        
        this.add(new JLabel("Stamp size: "));
        stampSize = new JTextField(3);
        this.add(stampSize);
        
        this.add(new JLabel("Stamping: "));
        
        rectStamp = new JButton("  Rectangle  ");
        rectStamp.setBorder(BorderFactory.createRaisedBevelBorder());
        rectStamp.setBackground(new Color(216, 223, 234));
        rectStamp.addActionListener(this);
        this.add(rectStamp);
        
        ovalStamp = new JButton("  Oval  ");
        ovalStamp.setBorder(BorderFactory.createRaisedBevelBorder());
        ovalStamp.setBackground(new Color(216, 223, 234));
        ovalStamp.addActionListener(this);
        this.add(ovalStamp);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (stampSize.getText().equals(""))
        {size = 0;}
        else
        {size = Integer.parseInt(stampSize.getText());}

        if (e.getSource().equals(oneWay))
        {DrawPanel.SYMMNUM = 1;}

        else if (e.getSource().equals(twoWay))
        {DrawPanel.SYMMNUM = 2;}

        else if (e.getSource().equals(fourWay))
        {DrawPanel.SYMMNUM = 4;}

        else if (e.getSource().equals(rectStamp))
        {
            DrawPanel.STAMPMODE = 4;
            DrawPanel.THICKNESS = size;
        }

        else if (e.getSource().equals(ovalStamp))
        {
            DrawPanel.STAMPMODE = 2;
            DrawPanel.THICKNESS = size;
        }

        this.dispose();
    }
}
