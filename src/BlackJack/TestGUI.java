import java.awt.*;
import javax.swing.*;

public class TestGUI {

    public static void createWindow(int WIDTH,int HEIGHT)
    {
        EventQueue.invokeLater(()->
        {
           var frame=new SimpleFrame(WIDTH, HEIGHT);
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
