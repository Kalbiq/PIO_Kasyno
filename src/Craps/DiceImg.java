package Craps;

import javax.swing.*;

public class DiceImg extends JLabel {
    ImageIcon img;
    String imgName;

    public DiceImg(){
        this.imgName = "dice1";
        setSize(100, 100);
        setImg(imgName);
    }

    public void setImg(String name){
        this.imgName = name;
        this.img = new ImageIcon("images/dices/" + imgName + ".png");
        this.setIcon(img);
        this.setVerticalAlignment(JLabel.CENTER);
    }
}
