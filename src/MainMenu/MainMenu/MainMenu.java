package MainMenu;

import SlotMachine.SlotMachine;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class MainMenu {

    private static JFrame frame;
    private static JPanel imagePanel;
    private static JPanel menuPanel;
    private static JPanel fundsPanel;
    private static JLabel imageLabel;
    private static JLabel labelFunds;
    private static JButton blackjackButton;
    private static JButton menuButton;
    private static JButton slotmachineButton;
    private static JButton crapsButton;
    private static JButton settingsButton;
    public static boolean isMusicPlaying;

    private static int FUNDS;

    static {
        FUNDS = 0;
        isMusicPlaying=false;
    }




    public static void main(String[] args)
    {
        File file = new File(System.getProperty("user.dir")+"\\gameData\\playerFunds.txt");

        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(scanner.hasNextInt())
        {
            FUNDS=scanner.nextInt();
        }



        EventQueue.invokeLater(() ->
        {

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            ImageIcon icon= new ImageIcon(System.getProperty("user.dir")+"\\images\\iconBlackjack.png");

            if(!isMusicPlaying) {
                isMusicPlaying=true;
                PlayMusic musicPlayer = new PlayMusic();
                try {
                    musicPlayer.playMusic("Nuta #1");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }

            frame=new JFrame("Kasyno Lichwiarz");
            frame.setSize(1200,700);
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setLayout(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setIconImage(icon.getImage());
            frame.getContentPane().setBackground( new Color(255, 167, 167) );

            imagePanel=new JPanel();
            imagePanel.setLayout(null);
            imagePanel.setBounds(395,10,410,280);
            imagePanel.setOpaque(true);

            ImageIcon image=new ImageIcon(System.getProperty("user.dir")+"\\images\\iconMenu.png");

            imageLabel=new JLabel();
            imageLabel.setBounds(0,0,410,280);
            imageLabel.setIcon(image);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(new Color(0,0,0, 0));

            imagePanel.add(imageLabel);


            menuPanel=new JPanel();
            menuPanel.setLayout(null);
            menuPanel.setBounds(400,300,400,320);
            menuPanel.setOpaque(true);
            menuPanel.setBackground(new Color(255, 167, 167));

            blackjackButton=new JButton("Blackjack");
            blackjackButton.setBounds(0,0,400,60);
            slotmachineButton=new JButton("Jednoręki Bandyta");
            slotmachineButton.setBounds(0,80,400,60);
            crapsButton=new JButton("Kości");
            crapsButton.setBounds(0,160,400,60);
            settingsButton=new JButton("Ustawienia");
            settingsButton.setBounds(0,240,400,60);

            menuButton=new JButton("menu");
            menuButton.setBounds(1000,600,200,60);



            fundsPanel=new JPanel();
            fundsPanel.setBounds(5,615,300,50);
            fundsPanel.setBackground(new Color(255, 167, 167));

            labelFunds=new JLabel("Twoje fundusze: "+FUNDS+" $");
            labelFunds.setBounds(0,0,300,50);
            labelFunds.setFont(new Font("MV Boli", Font.BOLD, 20));
            labelFunds.setForeground(Color.white);
            fundsPanel.add(labelFunds);

            addPanels();


            blackjackButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            frame.setVisible(false);
                            frame.dispose();
                            BJ.BlackJack.main(new String[]{});

                        }

                    }
            );
            slotmachineButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.getContentPane().removeAll();
                            frame.add(new SlotMachine(FUNDS));
                            frame.revalidate();
                            frame.repaint();
                            frame.add(menuButton);


                        }

                    }
            );
            menuButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.getContentPane().removeAll();
                            frame.revalidate();
                            addPanels();
                            frame.repaint();




                        }

                    }
            );

            settingsButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Settings settings=new Settings();
                            settings.displaySettings();

                        }

                    }
            );



        });
    }

    private static void addPanels() {
        frame.add(imagePanel);
        menuPanel.add(blackjackButton);
        menuPanel.add(slotmachineButton);
        menuPanel.add(crapsButton);
        menuPanel.add(settingsButton);

        frame.add(menuPanel);
        frame.add(fundsPanel);
    }

}
