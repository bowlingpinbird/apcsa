/**
 * Window that allows you to pick settings for the 'pen'
 * 
 * @author Rachel Hu
 * @version v2 (June 7, 2021)
 */

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PenOptions extends JFrame implements ActionListener
{
    private JComboBox<String> penPicker;
    
    private JPanel lineOptions;

        private JLabel rotSymLabel;
        private JComboBox<Integer> rotations;

        private JLabel stampOpLabel;
        private JComboBox<String> stampOptions;

        private JLabel stampSizeLabel;
        private JTextField stampSize;

        private JButton sizeEnter;

    private JPanel shapeOptions;
        private JComboBox<String> shapePicker;
        private JButton fill;
        private JButton outline;
        
    public PenOptions()
    {
        super("Pen Options");
        this.setSize(210, 220);
        this.setLayout(new FlowLayout());

        penPicker = new JComboBox<String>(new String[] {"", "Freehand", "Shape"});
        penPicker.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        penPicker.addActionListener(this);
        this.add(penPicker);
        
        lineOptions = new JPanel();
        lineOptions.setVisible(false);
        lineOptions.setLayout(new BoxLayout(lineOptions, BoxLayout.PAGE_AXIS));
        this.add(lineOptions);

            rotSymLabel = new JLabel("Rotational Symmetry: ");
            rotSymLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lineOptions.add(rotSymLabel);

            rotations = new JComboBox<Integer>(new Integer[] {1, 2, 4});
            rotations.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            rotations.addActionListener(this);
            lineOptions.add(rotations);
            
            stampOpLabel = new JLabel("Stamping: ");
            stampOpLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lineOptions.add(stampOpLabel);
            
            stampOptions = new JComboBox<String>(new String[] {"Off", "Square", "Circle"});
            stampOptions.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            stampOptions.addActionListener(this);
            lineOptions.add(stampOptions);

            stampSizeLabel = new JLabel("Stamp Size: ");
            stampSizeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lineOptions.add(stampSizeLabel);

            stampSize = new JTextField(3);
            stampSize.setFont(new Font("Segoe UI", Font.PLAIN, 12));;
            lineOptions.add(stampSize);

                sizeEnter = new JButton(" Enter ");
                sizeEnter.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                sizeEnter.setBackground(new Color(216, 223, 234));
                sizeEnter.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                sizeEnter.addActionListener(this);
                lineOptions.add(sizeEnter);
        
        shapeOptions = new JPanel();
        shapeOptions.setVisible(false);
        this.add(shapeOptions);

            shapePicker = new JComboBox<String>(new String[] {"", "Rectangle", "Oval"});
            shapePicker.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            shapePicker.addActionListener(this);
            shapeOptions.add(shapePicker);

            fill = new JButton(" Fill ");
            fill.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            fill.setBackground(new Color(216, 223, 234));
            fill.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            fill.addActionListener(this);
            shapeOptions.add(fill);

            outline = new JButton(" Outline ");
            outline.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            outline.setBackground(new Color(216, 223, 234));
            outline.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            outline.addActionListener(this);
            shapeOptions.add(outline);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //checks the top ComboBox to determine whether to show lineOptions or shapeOptions
        if (e.getSource().equals(penPicker))
        {
            if (penPicker.getSelectedIndex() == 1)
            {
                lineOptions.setVisible(true);
                shapeOptions.setVisible(false);
                DrawPanel.SHAPEMODE = 1;
            }
            else if (penPicker.getSelectedIndex() == 2)
            {
                lineOptions.setVisible(false);
                shapeOptions.setVisible(true);
            }
        }
        
        //changes the rotational symmetry value
        else if (e.getSource().equals(rotations))
        {DrawPanel.SYMMNUM = (int) rotations.getSelectedItem();}

        //changes the stamping mode
        else if (e.getSource().equals(stampOptions))
        {
            if (stampOptions.getSelectedIndex() == 0)
            {DrawPanel.STAMPMODE = 1;}

            else if (stampOptions.getSelectedIndex() == 1)
            {DrawPanel.STAMPMODE = 4;}

            else if (stampOptions.getSelectedIndex() == 2)
            {DrawPanel.STAMPMODE = 2;}
        }

        //changes the size of the stamps
        else if (e.getSource().equals(sizeEnter))
        {
            try {
                DrawPanel.THICKNESS = Integer.parseInt(stampSize.getText());
            } catch (Exception exp) {
                DrawPanel.THICKNESS = 0;
            }
        }

        //changes the shape mode
        else if (e.getSource().equals(shapePicker))
        {
            if (shapePicker.getSelectedIndex() == 1)
            {DrawPanel.SHAPEMODE = 4;}
            else if (shapePicker.getSelectedIndex() == 2)
            {DrawPanel.SHAPEMODE = 2;}
        }

        else if (e.getSource().equals(fill))
        {DrawPanel.FILLMODE = true;}

        else if (e.getSource().equals(outline))
        {DrawPanel.FILLMODE = false;}
    }
    
}