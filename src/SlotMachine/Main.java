package SlotMachine;
import javax.swing.ImageIcon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("images/Banana.png");
        Border border = BorderFactory.createLineBorder(Color.green, 3);

        /*JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);*/

        /*JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);

        JLabel label = new JLabel();
        label.setText("Siema siema");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // ustawianie tekstu w oknie
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("MV Boli", Font.PLAIN,20));   //set font of text
        //label.setIconTextGap(100);
        //label.setOpaque(true);  //display label background
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);  // set vertical position of icon + text in label
        label.setHorizontalAlignment(JLabel.CENTER);  // set horizontal postion of icon + teks inlabel
        label.setBounds(0, 0, 250, 250); // set x,y position witjin frame as well as dimensions*/

	    JFrame frame = new SlotMachine(100);
        /*redPanel.add(label);
        frame.setLayout(null);
        frame.add(redPanel);
       // frame.add(bluePanel);
       // frame.add(greenPanel);

        //frame.pack();   // dodtosowywuje wielkośc ramki do obiektów
*/
    }
}
