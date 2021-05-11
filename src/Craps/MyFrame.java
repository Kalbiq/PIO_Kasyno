package Craps;

import com.sun.jdi.IntegerValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private final GameLogic gameLogic;
//    private JPanel dicePanel;
//    private JPanel selectPanel;
    private final DiceImg dice1;
    private final DiceImg dice2;
    private final JSpinner stakeSpinner;
    private final JLabel scoreLabel;
    private final JLabel scoreText;
    //private final JComboBox<List<Bet>> betCombo;


    public MyFrame() {
        super("Gra w kości");
        gameLogic = new GameLogic();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(600, 400));

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.X_AXIS));
        mainContainer.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));

        JPanel betContainer = new JPanel();
        betContainer.setLayout(new BoxLayout(betContainer, BoxLayout.Y_AXIS));
        betContainer.setMaximumSize(new Dimension(250, 2000));
        betContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        betContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);
        betContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        JPanel playContainer = new JPanel();
        playContainer.setLayout(new BoxLayout(playContainer, BoxLayout.Y_AXIS));
        playContainer.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        playContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);
        playContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        // Bet Container
        scoreText = new JLabel();
        scoreText.setText("Twoje fundusze: " + gameLogic.getScore());
        scoreText.setFont(new Font("MV Boli", Font.BOLD,20));
        scoreText.setAlignmentY(Component.TOP_ALIGNMENT);
        scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel stakePanel = new JPanel();
        stakePanel.setLayout(new BoxLayout(stakePanel, BoxLayout.X_AXIS));
        stakePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        stakePanel.setAlignmentY(Component.TOP_ALIGNMENT);
        stakePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel stakeText = new JLabel();
        stakeText.setText("Ile obstawiasz: ");
        stakeText.setFont(new Font("MV Boli", Font.BOLD,20));

        stakeSpinner = new JSpinner(new SpinnerNumberModel(5,5,100,5));
        stakeSpinner.setMaximumSize(new Dimension(50, 30));

        stakePanel.add(stakeText);
        stakePanel.add(stakeSpinner);

        //betCombo = new JComboBox<List<Bet>>(gameLogic.bets);

        betContainer.add(scoreText);
        betContainer.add(stakePanel);

        // Play Container
        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.X_AXIS));
        dicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dicePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

        dice1 = new DiceImg();
        dice1.setAlignmentX(Component.CENTER_ALIGNMENT);
        dice2 = new DiceImg();
        dice2.setAlignmentX(Component.CENTER_ALIGNMENT);

        dicePanel.add(dice1);
        dicePanel.add(dice2);

        scoreLabel = new JLabel();
        scoreLabel.setText("Twoje fundusze: " + gameLogic.getScore() + "$");
        scoreLabel.setFont(new Font("MV Boli", Font.BOLD,20));
        scoreLabel.setOpaque(true);
        scoreLabel.setVerticalAlignment(JLabel.BOTTOM);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        button = new JButton();
        button.setSize(150, 75);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText("Rzuć!");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));

        playContainer.add(dicePanel);
        playContainer.add(scoreLabel);
        playContainer.add(button);

        // Main container
        mainContainer.add(betContainer);
        mainContainer.add(playContainer);

        this.add(mainContainer);
        this.setVisible(true);
        /*
        dicePanel = new JPanel();
        dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.LINE_AXIS));
        dicePanel.setBounds(225, 20, 250, 100);
        dicePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        dice1 = new DiceImg(225, 20);
        dice2 = new DiceImg(375, 20);

        dicePanel.add(dice1);
        dicePanel.add(dice2);

        // wybranie zakladu, stawki i opis zakladu
        selectPanel = new JPanel();
        selectPanel.setBounds(0, 0, 200, 460);
        selectPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        stakeSpinner = new JSpinner(new SpinnerNumberModel(5,5,100,5));
        selectPanel.add(new JLabel("Stawka:"));
        selectPanel.add(stakeSpinner);

        //score panel
        scoreLabel = new JLabel();
        scoreLabel.setText("Twoje fundusze: " + gameLogic.getScore() + "$");
        scoreLabel.setFont(new Font("MV Boli", Font.BOLD,20));
        scoreLabel.setOpaque(true);
        scoreLabel.setVerticalAlignment(JLabel.BOTTOM);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setBounds(200, 150, 300, 150);

        JPanel scorePanel = new JPanel();
        scorePanel.setBounds(200, 150, 400, 150);
        scorePanel.add(scoreLabel);

        setLayout(null);
        add(dicePanel);
        add(selectPanel);
        add(scorePanel);
        addButton();
        setVisible(true);
        */
    }

    private void addButton() {
        button = new JButton();
        button.setBounds(275, 300, 150, 50);
        button.setText("Rzuć!");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button && gameLogic.getScore() > 0) {
            int bet = 6;
            int stake = (Integer) stakeSpinner.getValue();
            boolean win = gameLogic.play(bet, stake);

            this.dice1.setImg("dice" + gameLogic.getDie(0));
            this.dice2.setImg("dice" + gameLogic.getDie(1));

            if (win) {
                // tekst o wygranej
                scoreLabel.setText("Wygrales! Twoje fundusze: " + gameLogic.getScore() + "$");
                scoreText.setText("Twoje fundusze: " + gameLogic.getScore());

            } else {
                //tekst o przegranej
                scoreLabel.setText("Przegrales. Twoje fundusze: " + gameLogic.getScore());
                scoreText.setText("Twoje fundusze: " + gameLogic.getScore());

            }
        }
    }
}
