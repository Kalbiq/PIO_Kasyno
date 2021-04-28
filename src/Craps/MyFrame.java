package Craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private GameLogic gameLogic;

    public MyFrame() {
        super("Gra w kości");
        gameLogic = new GameLogic();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        //JButton playButton = new JButton("GRAJ");
        //add(playButton);
        setLayout(null);
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
            gameLogic.play();
        }
    }
}
