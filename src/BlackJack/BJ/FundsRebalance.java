package BJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class FundsRebalance {

    private static JFrame frame;
    private static JLabel label;
    private static JPanel warningPanel;
    private static JPanel buttonPanel;
    private static JButton okButton;
    private static JButton cancelButton;

    public static void addBalance(int playerFUNDS, int add)
    {

        playerFUNDS=playerFUNDS+add;

        try {
            FileWriter writer=new FileWriter(System.getProperty("user.dir")+"\\gameData\\playerFunds.txt");

            if(playerFUNDS>9999)
            {
                playerFUNDS=9999;
            }

            writer.write(Integer.toString(playerFUNDS));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void subtractBalance(int playerFUNDS, int sub)
    {
        playerFUNDS=playerFUNDS-sub;

        try {
            FileWriter writer=new FileWriter(System.getProperty("user.dir")+"\\gameData\\playerFunds.txt");
            writer.write(Integer.toString(playerFUNDS));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayWarning(int value, int playerFUNDS, JFrame refFrame)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon icon=new ImageIcon(System.getProperty("user.dir")+"\\images\\errorIcon.png");

        frame = new JFrame("Uwaga!");
        frame.setSize(300,200);
        frame.setIconImage(icon.getImage());
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);



        label=new JLabel("Porzucając tę rozgrywkę stracisz "+value+" $ !");
        label.setBounds(0,0,300,75);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setVerticalTextPosition(JLabel.CENTER);

        warningPanel=new JPanel();
        warningPanel.setBounds(0,25,300,75);
        warningPanel.add(label);
        warningPanel.setOpaque(true);

        okButton=new JButton("OK");
        cancelButton=new JButton("Anuluj");

        buttonPanel=new JPanel();
        buttonPanel.setBounds(75,100,150,50);
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setOpaque(true);

        frame.add(warningPanel);
        frame.add(buttonPanel);

        okButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.setVisible(false);
                        frame.dispose();
                        FundsRebalance.subtractBalance(playerFUNDS,value);
                        refFrame.setVisible(false);
                        refFrame.dispose();
                        BlackJack.main(new String[]{});

                    }


                }
        );

        cancelButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.setVisible(false);
                        frame.dispose();

                    }


                }
        );



    }




    public static void displayWarningToMenu(int value, int playerFUNDS, JFrame refFrame)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon icon=new ImageIcon(System.getProperty("user.dir")+"\\images\\errorIcon.png");

        frame = new JFrame("Uwaga!");
        frame.setSize(300,200);
        frame.setIconImage(icon.getImage());
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);



        label=new JLabel("Porzucając tę rozgrywkę stracisz "+value+" $ !");
        label.setBounds(0,0,300,75);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setVerticalTextPosition(JLabel.CENTER);

        warningPanel=new JPanel();
        warningPanel.setBounds(0,25,300,75);
        warningPanel.add(label);
        warningPanel.setOpaque(true);

        okButton=new JButton("OK");
        cancelButton=new JButton("Anuluj");

        buttonPanel=new JPanel();
        buttonPanel.setBounds(75,100,150,50);
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setOpaque(true);

        frame.add(warningPanel);
        frame.add(buttonPanel);

        okButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.setVisible(false);
                        frame.dispose();
                        FundsRebalance.subtractBalance(playerFUNDS,value);
                        refFrame.setVisible(false);
                        refFrame.dispose();
                        MainMenu.MainMenu.main(new String[]{});

                    }


                }
        );

        cancelButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.setVisible(false);
                        frame.dispose();

                    }


                }
        );


    }

}
