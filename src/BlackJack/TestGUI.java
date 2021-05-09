import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TestGUI implements ActionListener {

    private JFrame frame;
    private JSpinner stakeSpinner;
    private JPanel gamePanel;
    private JPanel controlPanel;
    private JPanel sumPanel;
    private JLayeredPane playerCardsPanel;
    private JLayeredPane enemyCardsPanel;
    private JPanel buttonsPanel;
    private JPanel resultPanel;
    private JButton buttonPlay;
    private JButton buttonPass;
    private JButton buttonMenu;
    private JButton buttonReset;
    private JLabel labelPlayer;
    private JLabel labelDealer;
    private JLabel labelResult;
    private JLabel labelSpinner;
    private JLabel labelFunds;
    private int playerCardsStart = 500;
    private int enemyCardsStart = 600;
    private int zPlayerOrder=0;
    private int zEnemyOrder=0;
    public int playerFUNDS;
    private boolean pass;
    private boolean reset;

    public void createWindow(int WIDTH, int HEIGHT, int FUNDS) {
        Player player = new Player();
        Player dealer = new Player();
        Deck deck = new Deck();
        deck.shuffleDeck();
        pass = false;
        reset= true;
        playerFUNDS=FUNDS;


        EventQueue.invokeLater(() ->
        {

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            ImageIcon icon= new ImageIcon(System.getProperty("user.dir")+"\\images\\iconBlackjack.png");

            frame = new SimpleFrame(WIDTH, HEIGHT);
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setResizable(false);
            frame.setLayout(null);
            frame.setIconImage(icon.getImage());

            labelResult = new JLabel("");
            labelResult.setHorizontalAlignment(JLabel.CENTER);
            labelResult.setVerticalAlignment(JLabel.CENTER);
            labelResult.setFont(new Font("Serif", Font.ITALIC, 80));
            labelResult.setBounds(400,190,400,100);


            resultPanel = new JPanel();
            resultPanel.setBounds(400, 200, 400, 120);
            resultPanel.setOpaque(true);
            resultPanel.add(labelResult);


            buttonPlay = new SimpleButton("Dobierz");
            buttonPass = new SimpleButton("Pass");
            buttonMenu = new SimpleButton("Menu");
            buttonMenu.setBounds(35,30,100,40);
            buttonReset = new SimpleButton("Reset");
            buttonReset.setBounds(1050,30,100,40);

            player.addCard(deck.drawCard());


            labelPlayer = new JLabel("Suma Twojej reki: " + player.sum);
            labelPlayer.setSize(300,50);
            labelPlayer.setBounds(450,0,300,50);
            labelPlayer.setHorizontalAlignment(JLabel.CENTER);
            labelPlayer.setFont(new Font("MV Boli", Font.BOLD, 20));
            labelPlayer.setForeground(Color.white);

            labelDealer = new JLabel("Suma reki krupiera: 0");
            labelDealer.setSize(300,50);
            labelDealer.setBounds(450,40,300,50);
            labelDealer.setHorizontalAlignment(JLabel.CENTER);
            labelDealer.setForeground(Color.white);
            labelDealer.setFont(new Font("MV Boli", Font.BOLD, 20));

            labelSpinner = new JLabel("Stawka:");
            labelSpinner.setBounds(50,25,200,50);
            labelSpinner.setForeground(Color.white);
            labelSpinner.setFont(new Font("MV Boli", Font.BOLD, 20));
            stakeSpinner = new JSpinner(new SpinnerNumberModel(0,0,FUNDS,5));
            ((JSpinner.DefaultEditor) stakeSpinner.getEditor()).getTextField().setEditable(false);
            stakeSpinner.setBounds(150,35,50,30);

            labelFunds= new JLabel("Fundusze: "+FUNDS+"$");
            labelFunds.setBounds(975,25,200,50);
            labelFunds.setForeground(Color.white);
            labelFunds.setFont(new Font("MV Boli", Font.BOLD, 20));

            gamePanel = new JPanel();
            gamePanel.setLayout(null);
            gamePanel.setBounds(0, 100, WIDTH, 500);
            gamePanel.add(labelResult);

            sumPanel = new JPanel();
            sumPanel.setLayout(null);
            sumPanel.setBackground(Color.DARK_GRAY);
            sumPanel.setBounds(0, 0, WIDTH, 100);
            sumPanel.add(labelSpinner);
            sumPanel.add(stakeSpinner);
            sumPanel.add(labelPlayer);
            sumPanel.add(labelDealer);
            sumPanel.add(labelFunds);

            buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1,1));
            buttonsPanel.setBounds(500, 25, 200, 50);
            buttonsPanel.add(buttonPlay);
            buttonsPanel.add(buttonPass);


            controlPanel = new JPanel();
            controlPanel.setBounds(0, 600, WIDTH, 100);
            controlPanel.setLayout(null);
            controlPanel.setBackground(Color.DARK_GRAY);
            controlPanel.add(buttonsPanel);
            controlPanel.add(buttonReset);
            controlPanel.add(buttonMenu);

            playerCardsPanel = new JLayeredPane();
            playerCardsPanel.setLayout(null);
            playerCardsPanel.setBackground(new Color(44, 173, 212));
            playerCardsPanel.setOpaque(true);
            playerCardsPanel.setBounds(0, 250, WIDTH, 250);
            playerCardsPanel.add(new Card(System.getProperty("user.dir") +
                    "\\images\\cards\\" + player.player_hand.get(player.cards_amount - 1) +
                    ".png", playerCardsStart).imageLabel, new Integer(zPlayerOrder));
            zPlayerOrder++;
            gamePanel.add(playerCardsPanel);

            enemyCardsPanel = new JLayeredPane();
            enemyCardsPanel.setBackground(new Color(0x2CADD4));
            enemyCardsPanel.setOpaque(true);
            enemyCardsPanel.setLayout(null);
            enemyCardsPanel.setBounds(0, 0, WIDTH, 250);


            //enemyCardsPanel.add(labelResult);
            gamePanel.add(enemyCardsPanel);


            frame.setTitle("Kasyno Lichwiarz - Blackjack");
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.add(gamePanel);
            frame.add(sumPanel);
            frame.add(controlPanel);

            //ZACHOWANIA PRZYCISKOW
            buttonPlay.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            stakeSpinner.setEnabled(false);

                            if (!pass) {
                                if (BlackjackLogic.checkPlayerSum(player.sum)) {
                                    player.addCard(deck.drawCard());
                                    playerCardsStart += 25;
                                    playerCardsPanel.add(new Card(System.getProperty("user.dir") +
                                            "\\images\\cards\\" + player.player_hand.get(player.cards_amount - 1) +
                                            ".png", playerCardsStart).imageLabel,new Integer(zPlayerOrder));
                                    zPlayerOrder++;
                                    playerCardsPanel.repaint();
                                    labelPlayer.setText("Suma Twojej reki: " + player.sum);
                                }

                                if (player.sum > 21) {
                                    labelResult.setForeground(Color.RED);
                                    labelResult.setText("Przegrales");
                                    FundsRebalance.subtractBalance(playerFUNDS, (Integer)stakeSpinner.getValue());
                                    playerFUNDS=playerFUNDS-(Integer)stakeSpinner.getValue();
                                    buttonPass.setEnabled(false);
                                    buttonPlay.setEnabled(false);
                                    labelFunds.setText("Fundusze: "+playerFUNDS+"$");
                                    gamePanel.repaint();
                                    reset=false;
                                } else if (player.sum == 21) {
                                    labelResult.setForeground(Color.GREEN);
                                    labelResult.setText("Wygrales");
                                    FundsRebalance.addBalance(playerFUNDS, (Integer)stakeSpinner.getValue());
                                    playerFUNDS=playerFUNDS+(Integer)stakeSpinner.getValue();
                                    buttonPass.setEnabled(false);
                                    buttonPlay.setEnabled(false);
                                    labelFunds.setText("Fundusze: "+playerFUNDS+"$");
                                    gamePanel.repaint();
                                    reset=false;
                                }
                            }

                        }
                    }
            );

            buttonPass.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            stakeSpinner.setEnabled(false);
                            pass = true;

                            buttonPlay.setEnabled(false);
                            buttonPass.setEnabled(false);
                            buttonReset.setEnabled(false);

                            Timer myTimer = new Timer();

                            TimerTask task = new TimerTask() {

                                public void run() {
                                    dealer.addCard(deck.drawCard());
                                    enemyCardsPanel.add(new Card(System.getProperty("user.dir") +
                                            "\\images\\cards\\" + dealer.player_hand.get(dealer.cards_amount - 1) +
                                            ".png", enemyCardsStart).imageLabel,new Integer(zEnemyOrder));
                                    zEnemyOrder++;
                                    enemyCardsStart -= 25;
                                    enemyCardsPanel.repaint();

                                    labelDealer.setText("Suma reki krupiera: " + dealer.sum);

                                    if (dealer.sum >= player.sum && dealer.sum<=21) {
                                        buttonReset.setEnabled(true);
                                        labelResult.setForeground(Color.RED);
                                        labelResult.setText("Przegrales");
                                        FundsRebalance.subtractBalance(playerFUNDS, (Integer)stakeSpinner.getValue());
                                        playerFUNDS=playerFUNDS-(Integer)stakeSpinner.getValue();
                                        labelFunds.setText("Fundusze: "+playerFUNDS+"$");
                                        gamePanel.repaint();
                                        reset=false;
                                        myTimer.cancel();

                                        } else if (dealer.sum>21){
                                        buttonReset.setEnabled(true);
                                        labelResult.setForeground(Color.GREEN);
                                        labelResult.setText("Wygrales");
                                        FundsRebalance.addBalance(playerFUNDS, (Integer)stakeSpinner.getValue());
                                        playerFUNDS=playerFUNDS+(Integer)stakeSpinner.getValue();
                                        labelFunds.setText("Fundusze: "+playerFUNDS+"$");
                                        gamePanel.repaint();
                                        reset=false;
                                        myTimer.cancel();
                                        }


                                    }


                            };


                            myTimer.scheduleAtFixedRate(task, 250, 1000);


                        }

                    });

            buttonReset.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            final int stake=(Integer)stakeSpinner.getValue();

                            if(reset && stake>0){
                                FundsRebalance.displayWarning(stake, playerFUNDS, frame);
                            }
                            else
                            {
                                BlackJack.main(new String[]{});
                                frame.setVisible(false);
                                frame.dispose();
                            }



                            }


                    }
            );



        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class SimpleFrame extends JFrame {
        public SimpleFrame(int WIDTH, int HEIGHT) {
            setSize(WIDTH, HEIGHT);
        }

    }

    class SimpleButton extends JButton {
        public SimpleButton(String text) {
            setText(text);
        }
    }

    class Card {
        JLabel imageLabel;
        ImageIcon image;

        Card(String path, int x) {
            image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(98, 150, Image.SCALE_DEFAULT));
            imageLabel = new JLabel(image);
            imageLabel.setBounds(x, 50, 98, 150);

        }

    }


}