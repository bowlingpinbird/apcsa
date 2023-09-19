/**
 * A window that pops up, allowing you to put in RGB values to pick the color to paint with
 *
 * @author Rachel Hu
 * @version v7 (June 8, 2021)
 */

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;

public class ColorPicker extends JFrame implements ChangeListener, ActionListener, DocumentListener
{
    private JLabel previewLabel;
    private JPanel previewPanel;
    private JPanel colorPreview;
    
    private JPanel sliderPanel;
        private JPanel RPanel;
        private JLabel RLabel;
        private JSlider R;
        private JTextField RField;
        private int r;

        private JPanel GPanel;
        private JLabel GLabel;
        private JSlider G;
        private JTextField GField;
        private int g;

        private JPanel BPanel;
        private JLabel BLabel;
        private JSlider B;
        private JTextField BField;
        private int b;

    private JButton enter;

    public ColorPicker()
    {
        super("Custom Color");
        this.setSize(400, 200);
        this.setVisible(true);

        r = DrawPanel.COLOR.getRed();
        g = DrawPanel.COLOR.getGreen();
        b = DrawPanel.COLOR.getBlue();

        previewPanel = new JPanel();
        previewPanel.setLayout(new BorderLayout());
        this.add(previewPanel, BorderLayout.WEST);

            previewLabel = new JLabel("       Preview         ");
            previewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            previewPanel.add(previewLabel, BorderLayout.NORTH);

            colorPreview = new JPanel();
            colorPreview.setBackground(DrawPanel.COLOR);
            colorPreview.setBorder(BorderFactory.createLineBorder(previewPanel.getBackground(), 10));
            previewPanel.add(colorPreview, BorderLayout.CENTER);
        
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));

            RPanel = new JPanel();
            RPanel.setBorder(BorderFactory.createLineBorder(RPanel.getBackground(), 5));

                RLabel = new JLabel("R ");
                RLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                RPanel.add(RLabel);

                R = new JSlider(JSlider.HORIZONTAL, 0, 225, 0);
                R.setValue(r);
                R.setMajorTickSpacing(15);
                R.setMinorTickSpacing(5);
                R.setPaintTicks(true);
                R.addChangeListener(this);
                RPanel.add(R);

                RField = new JTextField(3);
                RField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                RField.getDocument().addDocumentListener(this);
                RPanel.add(RField);                

            sliderPanel.add(RPanel);

            GPanel = new JPanel();
            GPanel.setBorder(BorderFactory.createLineBorder(GPanel.getBackground(), 5));
            
                GLabel = new JLabel("G ");
                GLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12)); 
                GPanel.add(GLabel);

                G = new JSlider(JSlider.HORIZONTAL, 0, 225, 0);
                G.setValue(g);
                G.setMajorTickSpacing(15);
                G.setMinorTickSpacing(5);
                G.setPaintTicks(true);
                G.addChangeListener(this);
                GPanel.add(G);

                GField = new JTextField(3);
                GField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                GField.getDocument().addDocumentListener(this);
                GPanel.add(GField);

            sliderPanel.add(GPanel);

            BPanel = new JPanel();
            BPanel.setBorder(BorderFactory.createLineBorder(BPanel.getBackground(), 5));
                
                BLabel = new JLabel("B ");
                BLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                BPanel.add(BLabel);

                B = new JSlider(JSlider.HORIZONTAL, 0, 225, 0);
                B.setValue(b);
                B.setMajorTickSpacing(15);
                B.setMinorTickSpacing(5);
                B.setPaintTicks(true);
                B.addChangeListener(this);
                BPanel.add(B);

                BField = new JTextField(3);
                BField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                BField.getDocument().addDocumentListener(this);
                BPanel.add(BField);

            sliderPanel.add(BPanel);

        this.add(sliderPanel, BorderLayout.CENTER);

        enter = new JButton(" Enter ");
        enter.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        enter.setBorder(BorderFactory.createRaisedBevelBorder());
        enter.setBackground(new Color(216, 223, 234));
        enter.addActionListener(this);
        this.add(enter, BorderLayout.SOUTH);
    }

    @Override
    public void stateChanged(ChangeEvent e) 
    {
        if (e.getSource().equals(R))
        {r = R.getValue();}

        else if (e.getSource().equals(G))
        {g = G.getValue();}

        else if(e.getSource().equals(B))
        {b = B.getValue();}

        colorPreview.setBackground(new Color(r, g, b));
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        DrawPanel.setColor(new Color(r, g, b));
        ArtWindow.updateCustomColorButtons();
        this.dispose();      
    }

    @Override
    public void insertUpdate(DocumentEvent e) 
    {
        if (RField.getText().equals(""))   
        {r = 0;}
        else if (Integer.parseInt(RField.getText()) > 255)   
        {r = 255;}
        else 
        {r = Integer.parseInt(RField.getText());}
        R.setValue(r);
        
        if (GField.getText().equals(""))   
        {g = 0;}
        else if (Integer.parseInt(GField.getText()) > 255)   
        {g = 255;}
        else
        {g = Integer.parseInt(GField.getText());}
        G.setValue(g);
        
        if (BField.getText().equals(""))   
        {b = 0;}
        else if (Integer.parseInt(BField.getText()) > 255)   
        {b = 255;}
        else
        {b = Integer.parseInt(BField.getText());}
        B.setValue(b);
        
        colorPreview.setBackground(new Color(r, g, b));
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) 
    {
        if (RField.getText().equals(""))   
        {r = 0;}
        else if (Integer.parseInt(RField.getText()) > 255)   
        {r = 255;}
        else 
        {r = Integer.parseInt(RField.getText());}
        R.setValue(r);
        
        if (GField.getText().equals(""))   
        {g = 0;}
        else if (Integer.parseInt(GField.getText()) > 255)   
        {g = 255;}
        else
        {g = Integer.parseInt(GField.getText());}
        G.setValue(g);
        
        if (BField.getText().equals(""))   
        {b = 0;}
        else if (Integer.parseInt(BField.getText()) > 255)   
        {b = 255;}
        else
        {b = Integer.parseInt(BField.getText());}
        B.setValue(b);
        
        colorPreview.setBackground(new Color(r, g, b));
    }

    //not used
    @Override
    public void changedUpdate(DocumentEvent e) 
    {}
}