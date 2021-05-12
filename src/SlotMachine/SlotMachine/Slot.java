package SlotMachine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Slot extends JLabel {
    private final int x;
    private final int y;
    ImageIcon slotImage;
    String slotName;

    public Slot(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, 100, 100);
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        setBorder(border);
        setSlotImage("banana");
    }

    public void setSlotImage(String iconName) {
        this.slotName = iconName;
        this.slotImage = new ImageIcon("images/" + iconName + ".png");
        this.setIcon(slotImage);
        this.setVerticalAlignment(JLabel.CENTER);
    }

    public String getSlotName() {
        return slotName;
    }
}
