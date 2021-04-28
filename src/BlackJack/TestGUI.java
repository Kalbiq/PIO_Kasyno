import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestGUI implements ActionListener {

    private JFrame frame;
    private JPanel gamePanel;
    private JPanel controlPanel;
    private JPanel sumPanel;
    private ImageIcon karta1;
    private JPanel playerCard2;
    public JPanel playerCardsPanel;
    private JPanel enemyCardsPanel;
    private JPanel buttonsPanel;
    private JPanel resultPanel;
    private JButton buttonPlay;
    private JButton buttonPass;
    private JLabel labelPlayer;
    private JLabel labelDealer;
    private JLabel labelResult;
    private int playerCardsStart=575;
    private int enemyCardsStart =600;
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
           frame=new SimpleFrame(WIDTH, HEIGHT);
           frame.setResizable(false);
           frame.setLayout(null);



           labelResult=new JLabel("");
           labelResult.setHorizontalAlignment(JLabel.CENTER);
           labelResult.setVerticalAlignment(JLabel.CENTER);
           labelResult.setFont(new Font("Serif", Font.ITALIC,80));


           resultPanel = new JPanel();
           resultPanel.setBounds(400,0,400,120);
           resultPanel.setOpaque(false);
           resultPanel.add(labelResult);


           buttonPlay=new SimpleButton("Dobierz");
           buttonPass=new SimpleButton("Pass");

           player.addCard(deck.drawCard());


           labelPlayer=new JLabel("Suma Twojej reki: "+player.sum);
           labelPlayer.setHorizontalAlignment(JLabel.CENTER);
           labelPlayer.setFont(new Font("MV Boli", Font.BOLD,15));
           labelPlayer.setForeground(Color.BLACK);

           labelDealer=new JLabel("Suma reki krupiera: 0");
           labelDealer.setHorizontalAlignment(JLabel.CENTER);
           labelDealer.setForeground(Color.BLACK);
           labelDealer.setFont(new Font("MV Boli", Font.BOLD,15));

           JPanel gamePanel = new JPanel();
           gamePanel.setLayout(null);
           gamePanel.setBounds(0,50,WIDTH,562);

           JPanel sumPanel = new JPanel();
           sumPanel.setLayout(new GridLayout(0,1));
           sumPanel.setBackground(Color.DARK_GRAY);
           sumPanel.setBounds(0,0,WIDTH,50);
           sumPanel.add(labelPlayer);
           sumPanel.add(labelDealer);

           JPanel buttonsPanel = new JPanel();
           buttonsPanel.setLayout(new GridLayout(2,2));
           buttonsPanel.setBounds(500,0,200,50);
           buttonsPanel.add(buttonPlay);
           buttonsPanel.add(buttonPass);

           JPanel controlPanel = new JPanel();
           controlPanel.setBounds(0,612,WIDTH,50);
           controlPanel.setLayout(null);
           controlPanel.setBackground(Color.GRAY);
           controlPanel.add(buttonsPanel);

           JPanel playerCardsPanel =new JPanel();
           playerCardsPanel.setLayout(null);
           playerCardsPanel.setBackground(new Color(177, 254, 205));
           playerCardsPanel.setBounds(0,281,WIDTH,281);
            playerCardsPanel.add(new Card("C:\\Users\\danio\\IdeaProjects\\PIO_Kasyno\\images\\cards\\" + player.player_hand.get(player.cards_amount-1)+".png",600).imageLabel);
           gamePanel.add(playerCardsPanel);

           JPanel enemyCardsPanel =new JPanel();
           enemyCardsPanel.setBackground(new Color(177, 254, 205));
           enemyCardsPanel.setLayout(null);
           enemyCardsPanel.setBounds(0,0,WIDTH,281);
           enemyCardsPanel.add(resultPanel);

           //enemyCardsPanel.add(labelResult);
           gamePanel.add(enemyCardsPanel);


           frame.setTitle("Test");
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

                            if(!pass) {
                                if (BlackjackLogic.checkPlayerSum(player.sum)) {
                                    player.addCard(deck.drawCard());
                                    playerCardsPanel.add( new Card("C:\\Users\\danio\\IdeaProjects\\PIO_Kasyno\\images\\cards\\" + player.player_hand.get(player.cards_amount-1)+".png",playerCardsStart).imageLabel);
                                    playerCardsStart-=25;
                                    playerCardsPanel.repaint();
                                    labelPlayer.setText("Suma Twojej reki: " + player.sum);
                                }

                                if (player.sum > 21) {
                                    labelResult.setForeground(Color.RED);
                                    labelResult.setText("Przegrales");
                                    buttonPass.setEnabled(false);
                                    buttonPlay.setEnabled(false);
                                } else if (player.sum == 21) {
                                    labelResult.setForeground(Color.GREEN);
                                    labelResult.setText("Wygrales");
                                    buttonPass.setEnabled(false);
                                    buttonPlay.setEnabled(false);
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
                            buttonPass.setEnabled(false);

                            Thread thread = new Thread(() -> {
                                do
                                {
                                    dealer.addCard(deck.drawCard());
                                    enemyCardsPanel.add( new Card("C:\\Users\\danio\\IdeaProjects\\PIO_Kasyno\\images\\cards\\" + dealer.player_hand.get(dealer.cards_amount-1)+".png",enemyCardsStart).imageLabel);
                                    enemyCardsStart-=25;
                                    enemyCardsPanel.repaint();

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
class Card{
        JLabel imageLabel;
        ImageIcon image;
        Card(String path, int x){
            image =new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(98,150,Image.SCALE_DEFAULT));
            imageLabel = new JLabel(image);
            imageLabel.setBounds(x,65,98,150);

        }

        }