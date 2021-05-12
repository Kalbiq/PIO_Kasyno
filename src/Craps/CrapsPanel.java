package Craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrapsPanel extends JPanel implements ActionListener {
    private final JButton rollButton;
    private final GameLogic gameLogic;
    private final DiceImg dice1;
    private final DiceImg dice2;
    private final JSpinner stakeSpinner;
    private final JLabel resultText;
    private final JLabel scoreText;
    private final JComboBox<Bet> betComboBox;
    private final JTextArea betDescriptionText;


    public CrapsPanel() {
        //super("Gra w kości");
        gameLogic = new GameLogic();
        this.setSize(1185, 700);
        this.setMinimumSize(new Dimension(600, 400));

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.X_AXIS));
        mainContainer.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));

        JPanel optionsContainer = new JPanel();
        optionsContainer.setLayout(new BoxLayout(optionsContainer, BoxLayout.Y_AXIS));
        optionsContainer.setMaximumSize(new Dimension(300, 2000));
        optionsContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        optionsContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);
        optionsContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        JPanel playContainer = new JPanel();
        playContainer.setLayout(new BoxLayout(playContainer, BoxLayout.Y_AXIS));
        playContainer.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        playContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);
        playContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        // Options Container
        scoreText = new JLabel();
        scoreText.setText("Twoje fundusze: $" + gameLogic.getScore());
        scoreText.setFont(new Font("Noto Sans", Font.BOLD, 20));
        scoreText.setAlignmentY(Component.TOP_ALIGNMENT);
        scoreText.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel stakePanel = new JPanel();
        stakePanel.setLayout(new BoxLayout(stakePanel, BoxLayout.X_AXIS));
        stakePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        stakePanel.setAlignmentY(Component.TOP_ALIGNMENT);
        stakePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel stakeLabel = new JLabel();
        stakeLabel.setText("Stawka: ");
        stakeLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));

        stakeSpinner = new JSpinner(new SpinnerNumberModel(5, 5, Integer.MAX_VALUE, 5));
        stakeSpinner.setMaximumSize(new Dimension(200, 30));
        stakeSpinner.setFont(new Font(stakeSpinner.getFont().getName(), Font.BOLD + Font.ITALIC, 16));

        stakePanel.add(stakeLabel);
        stakePanel.add(stakeSpinner);

        JPanel betPanel = new JPanel();
        betPanel.setLayout(new BoxLayout(betPanel, BoxLayout.Y_AXIS));
        betPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        betPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        betPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel betLabel = new JLabel();
        betLabel.setText("Zakład:");
        betLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
        betLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        betComboBox = new JComboBox<>();
        betComboBox.setMaximumSize(new Dimension(200, 30));
        for (Bet bet : gameLogic.getBets()) {
            betComboBox.addItem(bet);
        }
        betComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        betComboBox.addActionListener(this);
        betComboBox.setFont(new Font("Noto Sans", Font.ITALIC + Font.BOLD, 16));

        JLabel betDescriptionLabel = new JLabel();
        betDescriptionLabel.setText("Szczegóły zakładu:");
        betDescriptionLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
        betDescriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        betDescriptionText = new JTextArea();
        betDescriptionText.setText(gameLogic.getBets().get(0).getDescription());
        betDescriptionText.setLineWrap(true);
        betDescriptionText.setWrapStyleWord(true);
        betDescriptionText.setFont(new Font("Noto Sans", Font.ITALIC + Font.BOLD, 16));
        betDescriptionText.setAlignmentX(Component.LEFT_ALIGNMENT);

        betPanel.add(betLabel);
        betPanel.add(betComboBox);
        betPanel.add(betDescriptionLabel);
        betPanel.add(betDescriptionText);

        optionsContainer.add(scoreText);
        optionsContainer.add(stakePanel);
        optionsContainer.add(betPanel);

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

        resultText = new JLabel();
        resultText.setFont(new Font("Noto Sans", Font.BOLD + Font.ITALIC, 20));
        resultText.setOpaque(true);
        resultText.setVerticalAlignment(JLabel.BOTTOM);
        resultText.setHorizontalAlignment(JLabel.CENTER);
        resultText.setAlignmentX(Component.CENTER_ALIGNMENT);

        rollButton = new JButton();
        rollButton.setSize(150, 75);
        rollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rollButton.setText("Rzuć!");
        rollButton.addActionListener(this);
        rollButton.setFocusable(false);
        rollButton.setFont(new Font("Comic Sans", Font.BOLD, 25));

        playContainer.add(dicePanel);
        playContainer.add(resultText);
        playContainer.add(rollButton);

        // Main Container
        mainContainer.add(optionsContainer);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton && gameLogic.getScore() > 0) {
            int bet = betComboBox.getSelectedIndex();
            int stake = (Integer) stakeSpinner.getValue();
            boolean win = gameLogic.play(bet, stake);

            this.dice1.setImg("dice" + gameLogic.getDie(0));
            this.dice2.setImg("dice" + gameLogic.getDie(1));

            if (win) {
                // tekst o wygranej
                resultText.setText("Wygrałeś!");

            } else {
                //tekst o przegranej
                resultText.setText("Przegrałeś.");

            }
            scoreText.setText("Twoje fundusze: $" + gameLogic.getScore());
        }
        if (e.getSource() == betComboBox) {
            betDescriptionText.setText(gameLogic.getBets().get(betComboBox.getSelectedIndex()).getDescription());
        }
    }
}
