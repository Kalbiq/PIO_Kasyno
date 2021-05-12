package MainMenu;

import BJ.BlackJack;
import BJ.FundsRebalance;
import Craps.CrapsPanel;
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
    public static JLabel labelFunds;
    private static JButton blackjackButton;
    private static JButton menuButton;
    private static JButton slotmachineButton;
    private static JButton crapsButton;
    private static JButton settingsButton;
    private static JButton invisibleButton;
    private static JLabel background;
    private static ImageIcon menuBg;
    private static ImageIcon slotBg;
    private static ImageIcon crapsBg;

    public static boolean isMusicPlaying;
    public static Settings settings;

    public static int FUNDS;

    static {
        FUNDS = 0;
        isMusicPlaying=false;
    }


    public static void main(String[] args)
    {
        File file = new File(System.getProperty("user.dir")+"/gameData/playerFunds.txt");

        Scanner scanner= null;
        try {
            scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(scanner.hasNextInt())
        {
            FUNDS=scanner.nextInt();

            if(FUNDS>9999)
            {
                FUNDS=9999;
                FundsRebalance.subtractBalance(10000,1);
            }
        }



        EventQueue.invokeLater(() ->
        {



            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            ImageIcon icon= new ImageIcon(System.getProperty("user.dir")+"/images/iconBlackjack.png");

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
           // frame.getContentPane().setBackground( new Color(71, 56, 56) );

            menuBg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"/images/casino.png").
                    getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT));
            slotBg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"/images/slotbg.png").
                    getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT));
            crapsBg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"/images/crapstable.jpg").
                    getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT));
            background = new JLabel();
            background.setIcon(menuBg);
            background.setBounds(0,0,1200,700);
            background.setOpaque(true);

            imagePanel=new JPanel();
            imagePanel.setLayout(null);
            imagePanel.setBounds(395,10,410,280);
            imagePanel.setOpaque(true);

            ImageIcon image=new ImageIcon(System.getProperty("user.dir")+"/images/iconMenu.png");

            imageLabel=new JLabel();
            imageLabel.setBounds(0,0,410,280);
            imageLabel.setIcon(image);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(new Color(0,0,0, 0));

            imagePanel.add(imageLabel);


            menuPanel=new JPanel();
            menuPanel.setLayout(null);
            menuPanel.setBounds(400,300,400,320);
            menuPanel.setOpaque(false);
           // menuPanel.setBackground(new Color(71, 56, 56));

            blackjackButton=new JButton("Blackjack");
            blackjackButton.setBounds(0,0,400,60);
            blackjackButton.setBackground(new Color(45, 39, 39));
            blackjackButton.setForeground(Color.white);
            slotmachineButton=new JButton("Jednoręki Bandyta");
            slotmachineButton.setBounds(0,80,400,60);
            slotmachineButton.setBackground(new Color(45, 39, 39));
            slotmachineButton.setForeground(Color.white);
            crapsButton=new JButton("Kości");
            crapsButton.setBounds(0,160,400,60);
            crapsButton.setBackground(new Color(45, 39, 39));
            crapsButton.setForeground(Color.white);
            settingsButton=new JButton("Ustawienia");
            settingsButton.setBounds(0,240,400,60);
            settingsButton.setBackground(new Color(45, 39, 39));
            settingsButton.setForeground(Color.white);
            invisibleButton=new JButton();
            invisibleButton.setBounds(0,0,0,0);

            menuButton=new JButton("Menu");
            menuButton.setBounds(15,585,200,60);



            fundsPanel=new JPanel();
            fundsPanel.setOpaque(false);
            fundsPanel.setBounds(5,615,300,50);
            // fundsPanel.setBackground(new Color(71, 56, 56));

            labelFunds=new JLabel("Twoje fundusze: "+FUNDS+" $");
            labelFunds.setBounds(0,0,300,50);
            labelFunds.setFont(new Font("MV Boli", Font.BOLD, 20));
            labelFunds.setForeground(Color.white);
            labelFunds.setOpaque(false);
            fundsPanel.add(labelFunds);

            addPanels();


            blackjackButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.getContentPane().removeAll();

                        BJ.BlackJack.main(new String[]{""});
                        FUNDS=BJ.BlackJack.FUNDS;

                        BJ.TestGUI bj=new BJ.TestGUI(1200,700,FUNDS);

                        frame.add(bj);

                        frame.validate();
                        bj.validate();

                        frame.repaint();
                        frame.revalidate();
                    }
                }
            );

            crapsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.getContentPane().removeAll();

                        background.setIcon(crapsBg);

                        frame.add(new CrapsPanel());
                        frame.revalidate();
                        frame.repaint();
                        frame.add(menuButton);
                        frame.add(background);
                    }
                }
            );

            slotmachineButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.getContentPane().removeAll();


                        background.setIcon(slotBg);
                        BJ.BlackJack.main(new String[]{""});
                        FUNDS=BJ.BlackJack.FUNDS;

                        frame.add(new SlotMachine(FUNDS));
                        frame.revalidate();
                        frame.repaint();
                        frame.add(menuButton);
                        frame.add(background);
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

                            if(settings==null) {
                                settings = new Settings();
                                settings.displaySettings();
                            }

                        }

                    }
            );



        });
    }

    public static void addPanels() {

        frame.getContentPane().removeAll();

        background.setIcon(menuBg);

        frame.repaint();
        frame.revalidate();

        BlackJack.main(new String[]{"",});
        FUNDS=BlackJack.FUNDS;

        labelFunds.setText("Twoje fundusze: "+FUNDS+" $");

        frame.add(imagePanel);
        menuPanel.add(invisibleButton);
        menuPanel.add(blackjackButton);
        menuPanel.add(slotmachineButton);
        menuPanel.add(crapsButton);
        menuPanel.add(settingsButton);

        frame.add(menuPanel);
        frame.add(fundsPanel);
        frame.add(background);

        frame.repaint();
        frame.revalidate();

    }

    public static void changeFunds(int value)
    {
        labelFunds.setText("Twoje fundusze: "+value+" $");
        labelFunds.repaint();
    }

    public static void refreshBlackjack()
    {
        frame.getContentPane().removeAll();


        BlackJack.main(new String[]{"",});
        FUNDS=BlackJack.FUNDS;


        BJ.TestGUI bj=new BJ.TestGUI(1200,700,FUNDS);

        frame.add(bj);


        frame.validate();
        bj.validate();

        frame.repaint();
        frame.revalidate();



    }

    public static void refreshFunds(int value)
    {
        System.out.println("refreshFunds");
        FUNDS-=value;
        refreshBlackjack();
    }

}
