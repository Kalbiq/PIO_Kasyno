package SlotMachine;

import BJ.BlackJack;
import BJ.FundsRebalance;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotMachine extends JPanel implements ActionListener {
    private int account;
    private JButton button;
    private JPanel machinePanel;
    private Slot slot1;
    private Slot slot2;
    private Slot slot3;
    private JLabel scoreLabel;
    private Image image;


    public SlotMachine(int account) {
        BJ.BlackJack.main(new String[] {","});
        this.account = BlackJack.FUNDS;

//visual panel
        Border border = BorderFactory.createLineBorder(Color.black, 5);

        slot1 = new Slot(200, 100);
        slot2 = new Slot(350, 100);
        slot3 = new Slot(500, 100);


        machinePanel = new JPanel();
        machinePanel.setBounds(200, 50, 350, 125);
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
        scoreLabel.setBounds(225, 200, 300, 50);
        scoreLabel.setBorder(border);


//Frame

        this.setSize(700, 500);  //x -dimension, y-dimesnsion
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(200, 100);
        this.setVisible(true);
        this.setLayout(null);
        this.add(machinePanel);
        this.add(scoreLabel);
        addButton();
    }
    private void addButton () {
        button = new JButton();
        button.setBounds(250, 275, 250, 100);
        button.setText("Graj!");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button && account >= 10) {
            play();
        }
        else if(e.getSource() == button && account < 10) {
            JOptionPane.showMessageDialog(null, "Nie masz wystarczających środków");
        }

    }
    
    public void play() {
        var random = new Random();
        var slots = new String[]{"Cherry", "Banana", "Diamond", "Gold", "Plum", "Clover", "Seven"};
        var simulationOutput = new int[]{-1, -1, -1};
        String message;

        FundsRebalance.subtractBalance(account,10);
        account -= 10;
        simulationOutput[0] = random.nextInt(7);
        slot1.setSlotImage(slots[simulationOutput[0]]);

        simulationOutput[1] = random.nextInt(7);
        slot2.setSlotImage(slots[simulationOutput[1]]);

        simulationOutput[2] = random.nextInt(7);
        slot3.setSlotImage(slots[simulationOutput[2]]);

        scoreLabel.setText("Twoje fundusze: " + account + "$");


        if(simulationOutput[0] == simulationOutput[1] && simulationOutput[0] == simulationOutput[2]) {
            if(simulationOutput[0] == 2) {
                FundsRebalance.addBalance(account,100);
                account += 100;
            }
            else if(simulationOutput[0] == 6) {
                FundsRebalance.addBalance(account,50);
                account += 50;
            }
            else {
                FundsRebalance.addBalance(account,20);
                account += 20;
            }
            message = "Wygrałeś 20$";

        }
        else if(simulationOutput[0] == simulationOutput[1] || simulationOutput[0] == simulationOutput[2]) {
            message = "Wygrałeś 15$";
            FundsRebalance.addBalance(account,15);
            account += 15;

        }
        else if(simulationOutput[1] == simulationOutput[2]) {
            message = "Wygrałeś 15$";
            FundsRebalance.addBalance(account,15);
            account += 15;

        }
        else
            message = "Nic nie wygrałeś";

    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }






}
