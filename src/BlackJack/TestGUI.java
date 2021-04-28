import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestGUI implements ActionListener {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel controlPanel;
    private JPanel sumPanel;
    private ImageIcon karta1;
    private JPanel playerCard2;
    private JPanel playerCardsPanel;
    private JPanel enemyCardsPanel;
    private JButton buttonPlay;
    private JButton buttonPass;
    private JLabel labelPlayer;
    private JLabel labelDealer;
    private JLabel labelResult;
    private boolean pass;

    public void createWindow(int WIDTH, int HEIGHT)
    {
        Player player=new Player();
        Player dealer=new Player();
        Deck deck= new Deck();
        deck.shuffleDeck();
        pass=false;


        EventQueue.invokeLater(()->
        {
           karta1= new ImageIcon(new ImageIcon("C:\\Users\\Paweł\\Desktop\\karty_zapasowe\\PNG\\C2.png").getImage().getScaledInstance(136,210,Image.SCALE_DEFAULT));


           frame=new SimpleFrame(WIDTH, HEIGHT);
           frame.setResizable(false);

           //INFORMACJA O REZLUTACIE GRY
           labelResult=new JLabel("");
           labelResult.setHorizontalAlignment(JLabel.CENTER);
           labelResult.setVerticalAlignment(JLabel.CENTER);
           labelResult.setBounds(100,200,50,100);
           labelResult.setFont(new Font("Serif", Font.ITALIC,80));

           //TWORZENIE GLOWNEGO PANELU
           mainPanel=new JPanel();
           mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

           //REKA GRACZA I KRUPIERA

           playerCardsPanel=new JPanel();
           playerCard2=new JPanel();
           playerCardsPanel.setBackground(Color.YELLOW);
           playerCardsPanel.setBorder(BorderFactory.createEmptyBorder(210,600,0,600));
           playerCardsPanel.setLayout(new GridLayout(1,9));
           labelResult.setIcon(karta1);
           playerCard2.setPreferredSize(new Dimension(140,80));
           playerCard2.setBackground(Color.BLACK);
          // playerCardsPanel.add(playerCard1);
          // playerCardsPanel.add(playerCard2);
           enemyCardsPanel=new JPanel();
           enemyCardsPanel.setBackground(Color.BLUE);
           enemyCardsPanel.setBorder(BorderFactory.createEmptyBorder(0,600,210,600));
           enemyCardsPanel.add(labelResult);

           //POLE GRY
           gamePanel=new JPanel();
           gamePanel.setPreferredSize(new Dimension(640, 480));
           gamePanel.setBackground(Color.DARK_GRAY);
           gamePanel.add(enemyCardsPanel);
           gamePanel.add(playerCardsPanel);


            //PRZYCISKI STERUJACE
           buttonPlay=new SimpleButton("Dobierz");
           buttonPass=new SimpleButton("Pass");

           //PIERWSZA KARTA DLA GRACZA
           player.addCard(deck.drawCard());

           //INFORMACJE TEKSTOWE O SUMACH
           labelPlayer=new JLabel("Suma Twojej reki: "+player.sum);
           labelPlayer.setHorizontalAlignment(JLabel.CENTER);
           labelPlayer.setFont(new Font("MV Boli", Font.BOLD,15));
           labelDealer=new JLabel("Suma reki krupiera: 0");
           labelDealer.setHorizontalAlignment(JLabel.CENTER);
           labelDealer.setFont(new Font("MV Boli", Font.BOLD,15));

           //PANELE: PRZYCISKOW I SUM GRACZY

           controlPanel=new JPanel();
           sumPanel=new JPanel();

           controlPanel.setBorder(BorderFactory.createEmptyBorder(25,300,25,300));
           controlPanel.setLayout(new GridLayout(2,2));
           controlPanel.setBackground(Color.GRAY);
           controlPanel.add(buttonPlay);
           controlPanel.add(buttonPass);

           sumPanel.setBorder(BorderFactory.createEmptyBorder(25,500,25,500));
           sumPanel.setLayout(new GridLayout(0,1));
           sumPanel.setBackground(Color.GRAY);
           sumPanel.add(labelPlayer);
           sumPanel.add(labelDealer);


           //DODAWANIE PANELI DO PANELA GLOWNEGO
           mainPanel.add(sumPanel);
           mainPanel.add(gamePanel);
           mainPanel.add(controlPanel);

           //DODAWANIE PANELA GLOWNEGO DO OKNA
           frame.add(mainPanel);
           frame.setTitle("TesT");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);


           //ZACHOWANIA PRZYCISKOW
            buttonPlay.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            if(!pass) {
                                if (BlackjackLogic.checkPlayerSum(player.sum)) {
                                    player.addCard(deck.drawCard());
                                    labelPlayer.setText("Suma Twojej reki: " + player.sum);
                                }

                                if (player.sum > 21) {
                                    labelResult.setForeground(Color.RED);
                                    labelResult.setText("Przegrales");
                                    buttonPass.setEnabled(false);
                                } else if (player.sum == 21) {
                                    labelResult.setForeground(Color.GREEN);
                                    labelResult.setText("Wygrales");
                                    buttonPass.setEnabled(false);
                                }
                            }

                        }
                    }
            );

            buttonPass.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pass=true;

                            buttonPlay.setEnabled(false);

                            Thread thread = new Thread(() -> {
                                do
                                {
                                    dealer.addCard(deck.drawCard());

                                    labelDealer.setText("Suma reki krupiera: "+dealer.sum);

                                try{
                                    Thread.sleep(1000);
                                }catch(InterruptedException ex){}


                                } while (BlackjackLogic.checkPlayerSum(dealer.sum)&&player.sum>dealer.sum);

                                if(BlackjackLogic.matchResult(dealer.sum,player.sum))
                                {
                                    labelResult.setForeground(Color.GREEN);
                                    labelResult.setText("Wygrales");
                                }
                                else
                                {
                                    labelResult.setForeground(Color.RED);
                                    labelResult.setText("Przegrales");
                                }

                            });
                            thread.start();



                        }
                    }
            );

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

class SimpleFrame extends JFrame
{
    public SimpleFrame(int WIDTH, int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
    }

}

class SimpleButton extends JButton
{
    public SimpleButton(String text) {setText(text);}
}