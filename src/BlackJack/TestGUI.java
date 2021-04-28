import java.awt.*;
import javax.swing.*;

public class TestGUI {

    public static void createWindow(int WIDTH,int HEIGHT)
    {
        EventQueue.invokeLater(()->
        {
           var frame=new SimpleFrame(WIDTH, HEIGHT);
           var controlPanel=new SimplePanel(200, 200);
           var buttonPlay=new SimpleButton("Graj");
           var buttonPass=new SimpleButton("Pass");

           controlPanel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
           controlPanel.setLayout(new GridLayout(0,1));
           controlPanel.add(buttonPlay);
           controlPanel.add(buttonPass);

           frame.add(controlPanel);
           frame.setTitle("Es");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });
    }

}

class SimpleFrame extends JFrame
{
    public SimpleFrame(int WIDTH, int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
    }

}

class SimplePanel extends JPanel
{
    public SimplePanel(int WIDTH, int HEIGHT){ setSize(WIDTH, HEIGHT);}
}

class SimpleButton extends JButton
{
    public SimpleButton(String text) {setText(text);}
}