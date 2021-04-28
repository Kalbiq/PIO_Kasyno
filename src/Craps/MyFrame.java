package Craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private GameLogic gameLogic;
    private JPanel dicePanel;
    private JPanel selectPanel;
    private DiceImg dice1;
    private DiceImg dice2;
    private JSpinner stakeSpinner;
    private JLabel scoreLabel;


    public MyFrame() {
        super("Gra w kości");
        gameLogic = new GameLogic();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        //JButton playButton = new JButton("GRAJ");
        //add(playButton);

        dicePanel = new JPanel();
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
        if(e.getSource()==button) {
            int bet = 6;
            int stake = (Integer) stakeSpinner.getValue();
            boolean win = gameLogic.play(bet, stake);

            this.dice1.setImg("dice" + gameLogic.getDie(0));
            this.dice2.setImg("dice" + gameLogic.getDie(1));

            if (win) {
                // tekst o wygranej
                scoreLabel.setText("Wygrales! Twoje fundusze: " + gameLogic.getScore() + "$");

            } else {
                //tekst o przegranej
                scoreLabel.setText("Przegrales. Twoje fundusze: " + gameLogic.getScore());

            }
        }
    }
}
