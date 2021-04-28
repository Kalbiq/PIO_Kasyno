package Craps;

import javax.swing.*;

public class DiceImg extends JLabel {
    private int x;
    private int y;
    ImageIcon img;
    String imgName;

    public DiceImg(int x, int y){
        this.x = x;
        this.y = y;
        this.imgName = "dice1";
        setBounds(x, y, 100, 100);
        setImg(imgName);
    }

    public void setImg(String name){
        this.imgName = name;
        this.img = new ImageIcon("images/" + imgName + ".png");
        this.setIcon(img);
        this.setVerticalAlignment(JLabel.CENTER);
    }
}
