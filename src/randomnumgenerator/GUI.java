
package randomnumgenerator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Graphical User Interface
 * @author Vance Field
 * @version 27-Dec-2016
 */
public class GUI extends JPanel {
    
    JButton button;
    JTextField[] text;
    
    public GUI(){
        setLayout(new FlowLayout());
        text = new JTextField[3];
        text[0] = new JTextField(3);
        text[0].setToolTipText("Enter minimum number for range");
        text[1] = new JTextField(3);
        text[1].setToolTipText("Enter maximum number for range");
        text[2] = new JTextField(5);
        add(text[0]);
        add(new JLabel("-"));
        add(text[1]);        
        text[2].setEditable(false);        
        button = new JButton("Generate");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int min = Integer.parseInt(text[0].getText());
                int max = Integer.parseInt(text[1].getText());
                Random rand = new Random();
                int num = rand.nextInt(max - min + 1) + min;
                System.out.println("Random number is:" + num);
                text[2].setText("" + num);
            }
        });
        add(button);
        add(text[2]);
    }
    
    public void display(){
        JFrame frame = new JFrame("Random Number Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.setPreferredSize(new Dimension(320, 70));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
