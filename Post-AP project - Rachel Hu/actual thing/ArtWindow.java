/**
 * A window that allows you to do the drawing
 * 
 * @author Rachel Hu
 * @version v9 (June 8, 2021) 
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class ArtWindow extends JFrame implements ActionListener
{
    private DrawPanel canvas;
    private JPanel menuBar;

    private JPanel colorMenu;
        private JButton customColor;
        private JButton red;
        private JButton orange;
        private JButton yellow;
        private JButton green;
        private JButton blue;
        private JButton magenta;
        private JButton black;
        private JButton white;
        private static JButton custom1;
        private static JButton custom2;
        private static JButton custom3;
        private static JButton custom4;
    
    private JPanel drawMenu;
        private JButton line;
        private JButton rectangle;
        private JButton oval;
        private JButton options;

    private JButton clear;

    public ArtWindow()  
    {
        //contructs the window
        super("Organic, homemade MS paint");
        this.setSize(800, 825);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //sets template/layout
        this.setLayout(new BorderLayout());

        //constructs a DrawPanel and adds it to the window
        canvas = new DrawPanel();
        this.add(canvas, BorderLayout.CENTER);

        //constructs a menuBar panel and adds it to the window
        menuBar = new JPanel();
        menuBar.setBackground(new Color(230, 232, 235));
        menuBar.setVisible(true);
        this.add(menuBar, BorderLayout.NORTH);
        
            colorMenu = new JPanel();
            colorMenu.setBackground(new Color(230, 232, 235));
            menuBar.add(colorMenu);
        
                red = new JButton("     ");
                red.addActionListener(this);
                red.setBorder(BorderFactory.createRaisedBevelBorder());
                red.setBackground(Color.RED);
                colorMenu.add(red);
                
                orange = new JButton("     ");
                orange.addActionListener(this);
                orange.setBorder(BorderFactory.createRaisedBevelBorder());
                orange.setBackground(Color.ORANGE);
                colorMenu.add(orange);
                
                yellow = new JButton("     ");
                yellow.addActionListener(this);
                yellow.setBorder(BorderFactory.createRaisedBevelBorder());
                yellow.setBackground(Color.YELLOW);
                colorMenu.add(yellow);
                
                green = new JButton("     ");
                green.addActionListener(this);
                green.setBorder(BorderFactory.createRaisedBevelBorder());
                green.setBackground(Color.GREEN);
                colorMenu.add(green);
                
                blue = new JButton("     ");
                blue.addActionListener(this);
                blue.setBorder(BorderFactory.createRaisedBevelBorder());
                blue.setForeground(Color.WHITE);
                blue.setBackground(Color.BLUE);
                colorMenu.add(blue);
                
                magenta = new JButton("     ");
                magenta.addActionListener(this);
                magenta.setBorder(BorderFactory.createRaisedBevelBorder());
                magenta.setBackground(Color.MAGENTA);
                colorMenu.add(magenta);
                
                black = new JButton("     ");
                black.addActionListener(this);
                black.setBorder(BorderFactory.createRaisedBevelBorder());
                black.setForeground(Color.WHITE);
                black.setBackground(Color.BLACK);
                colorMenu.add(black);
                
                white = new JButton("     ");
                white.addActionListener(this);
                white.setBorder(BorderFactory.createRaisedBevelBorder());
                white.setBackground(Color.WHITE);
                colorMenu.add(white);

                colorMenu.add(new JLabel(" || "));
                
                custom1 = new JButton("     ");
                custom1.addActionListener(this);
                custom1.setBorder(BorderFactory.createRaisedBevelBorder());
                custom1.setBackground(DrawPanel.COLOR);
                colorMenu.add(custom1);
                
                custom2 = new JButton("     ");
                custom2.addActionListener(this);
                custom2.setBorder(BorderFactory.createRaisedBevelBorder());
                custom2.setBackground(DrawPanel.OLD_COLOR);
                colorMenu.add(custom2);
                
                custom3 = new JButton("     ");
                custom3.addActionListener(this);
                custom3.setBorder(BorderFactory.createRaisedBevelBorder());
                custom3.setBackground(DrawPanel.EXTRA_OLD_COLOR);
                colorMenu.add(custom3);
                
                custom4 = new JButton("     ");
                custom4.addActionListener(this);
                custom4.setBorder(BorderFactory.createRaisedBevelBorder());
                custom4.setBackground(DrawPanel.EXTREMELY_OLD_COLOR);
                colorMenu.add(custom4);
                
                colorMenu.add(new JLabel(" || "));

                customColor = new JButton(" Custom Color ");
                customColor.addActionListener(this);
                customColor.setBorder(BorderFactory.createRaisedBevelBorder());
                customColor.setBackground(new Color(216, 223, 234));
                customColor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                colorMenu.add(customColor);
            
            drawMenu = new JPanel();
            drawMenu = new JPanel();
            drawMenu.setBackground(new Color(230, 232, 235));
            drawMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            drawMenu.setVisible(true);
            menuBar.add(drawMenu);

                line = new JButton(" Freehand ");
                line.addActionListener(this);
                line.setBorder(BorderFactory.createRaisedBevelBorder());
                line.setBackground(new Color(216, 223, 234));
                line.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                drawMenu.add(line);

                rectangle = new JButton(" Rectangle ");
                rectangle.addActionListener(this);
                rectangle.setBorder(BorderFactory.createRaisedBevelBorder());
                rectangle.setBackground(new Color(216, 223, 234));
                rectangle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                drawMenu.add(rectangle);

                oval = new JButton(" Oval ");
                oval.addActionListener(this);
                oval.setBorder(BorderFactory.createRaisedBevelBorder());
                oval.setBackground(new Color(216, 223, 234));
                oval.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                drawMenu.add(oval);

                options = new JButton(" ∙∙∙ ");
                options.addActionListener(this);
                options.setBorder(BorderFactory.createRaisedBevelBorder());
                options.setBackground(new Color(216, 223, 234));
                options.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                drawMenu.add(options);

            clear = new JButton(" Clear ");
            clear.addActionListener(this);
            clear.setBorder(BorderFactory.createRaisedBevelBorder());
            clear.setBackground(new Color(216, 223, 234));
            clear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            menuBar.add(clear);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // colorbuttons
        if (e.getSource().equals(red)) {
            DrawPanel.setColor(red.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(orange)) {
            DrawPanel.setColor(orange.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(yellow)) {
            DrawPanel.setColor(yellow.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(green)) {
            DrawPanel.setColor(green.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(blue)) {
            DrawPanel.setColor(blue.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(magenta)) {
            DrawPanel.setColor(magenta.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(black)) {
            DrawPanel.setColor(black.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(white)) {
            DrawPanel.setColor(white.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(custom1)) {
            DrawPanel.setColor(custom1.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(custom2)) {
            DrawPanel.setColor(custom2.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(custom3)) {
            DrawPanel.setColor(custom3.getBackground());
            updateCustomColorButtons();
        }

        else if (e.getSource().equals(custom4)) {
            DrawPanel.setColor(custom4.getBackground());
            updateCustomColorButtons();
        }
        
        else if (e.getSource().equals(customColor))
        {new ColorPicker();}

        //drawing mode buttons
        else if (e.getSource().equals(line))
        {DrawPanel.SHAPEMODE = 1;}

        else if (e.getSource().equals(rectangle))
        {DrawPanel.SHAPEMODE = 4;}

        else if (e.getSource().equals(oval))
        {DrawPanel.SHAPEMODE = 2;}

        else if (e.getSource().equals(options))
        {new PenOptions();}

        else if(e.getSource().equals(clear))
        {canvas.clear();}
    }
    
    public static void updateCustomColorButtons()
    {
        custom1.setBackground(DrawPanel.COLOR);
        custom2.setBackground(DrawPanel.OLD_COLOR);
        custom3.setBackground(DrawPanel.EXTRA_OLD_COLOR);
        custom4.setBackground(DrawPanel.EXTREMELY_OLD_COLOR);
    }
}
