package Craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private GameLogic gameLogic;
    private JPanel dicePanel;
    private JPanel selectPanel;
    private DiceImg dice1;
    private DiceImg dice2;

    public MyFrame() {
        super("Gra w kości");
        gameLogic = new GameLogic();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        //JButton playButton = new JButton("GRAJ");
        //add(playButton);

        dicePanel = new JPanel();
        dicePanel.setBounds(200, 50, 300, 100);
        dicePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        dice1 = new DiceImg(200, 50);
        dice2 = new DiceImg(350, 50);

        dicePanel.add(dice1);
        dicePanel.add(dice2);

        // wybranie zakladu, stawki i opis zakladu
        selectPanel = new JPanel();
        dicePanel.setBounds(200, 160, 300, 100);
        dicePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(null);
        this.add(dicePanel);
        this.add(selectPanel);
        addButton();
        setVisible(true);

    }

    private void addButton() {
        button = new JButton();
        button.setBounds(225, 225, 250, 100);
        button.setText("Graj!");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            int bet = 0;
            int stake = 10;
            boolean win = gameLogic.play(bet, stake);

            this.dice1.setImg("d" + gameLogic.getDie(0));
            this.dice2.setImg("d" + gameLogic.getDie(1));

            if (win) {
                //tekst o wygranej
            } else {
                //tekst o przegranej
            }
        }
    }
}
