package Craps;

import javax.swing.*;

public class DiceImg extends JLabel {
    private String imgName;

    public DiceImg() {
        this.imgName = "dice1";
        this.setSize(100, 100);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setImg(imgName);
    }

    public void setImg(String name) {
        this.imgName = name;
        ImageIcon img = new ImageIcon("images/dices/" + imgName + ".png");
        this.setIcon(img);
        this.setVerticalAlignment(JLabel.CENTER);
    }
}
