package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotMachine extends JFrame implements ActionListener {
    private int account;
    private JButton button;
    private JPanel machinePanel;
    private Slot slot1;
    private Slot slot2;
    private Slot slot3;
    private JLabel scoreLabel;
    

    public SlotMachine(int account) {

        this.account = account;

//visual panel
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        //ImageIcon machineImage = new ImageIcon("images/machine.png");

       // JLabel machineLabel = new JLabel();
       // machineLabel.setIcon(machineImage);
        //machineLabel.setBounds(0, 0, 600, 600);

        slot1 = new Slot(100, 100);
        slot2 = new Slot(250, 100);
        slot3 = new Slot(400, 100);

        machinePanel = new JPanel();
        machinePanel.setBounds(100, 50, 400, 150);
        machinePanel.setBorder(border);

        machinePanel.add(slot1);
        machinePanel.add(slot2);
        machinePanel.add(slot3);
       // visualPanel.add(machineLabel);



//score panel
        scoreLabel = new JLabel();
        scoreLabel.setText("Twoje fundusze: " + account + "$");
        scoreLabel.setFont(new Font("MV Boli", Font.BOLD,20));
        scoreLabel.setOpaque(true);
        scoreLabel.setVerticalAlignment(JLabel.BOTTOM);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setBounds(100, 350, 300, 150);
        scoreLabel.setBorder(border);

        JPanel scorePanel = new JPanel();
        scorePanel.setBounds(100, 350, 400, 150);
        scorePanel.add(scoreLabel);
        scorePanel.add(scoreLabel);

//Frame
        this.setTitle("Jednoręki Bandyta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wychodzi z aplikacji po klknieciu krzyzyka
        this.setResizable(false);
        this.setSize(700, 500);  //x -dimension, y-dimesnsion
        this.setVisible(true);
        this.setLayout(null);
        this.add(machinePanel);
        this.add(scorePanel);
        addButton();
    }
    private void addButton () {
        button = new JButton();
        button.setBounds(175, 225, 250, 100);
        button.setText("Graj!");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            play();
        }
    }
    
    public void play() {
        var random = new Random();
        var slots = new String[]{"Cherry", "Banana", "Diamond", "Gold", "Plum", "Clover", "Seven"};
        var simulationOutput = new int[]{-1, -1, -1};
        String message;

        account -= 3;
        simulationOutput[0] = random.nextInt(7);
        slot1.setSlotImage(slots[simulationOutput[0]]);

        simulationOutput[1] = random.nextInt(7);
        slot2.setSlotImage(slots[simulationOutput[1]]);

        simulationOutput[2] = random.nextInt(7);
        slot3.setSlotImage(slots[simulationOutput[2]]);

        scoreLabel.setText("Twoje fundusze: " + account + "$");


        if(simulationOutput[0] == simulationOutput[1] && simulationOutput[0] == simulationOutput[2]) {
            message = "Wygrałeś 10$";
            account += 10;
        }
        else if(simulationOutput[0] == simulationOutput[1] || simulationOutput[0] == simulationOutput[2]) {
            message = "Wygrałeś 5$";
            account += 5;
        }
        else if(simulationOutput[1] == simulationOutput[2]) {
            message = "Wygrałeś 5$";
            account +=5;
        }
        else
            message = "Nic nie wygrałeś";

    }
}
