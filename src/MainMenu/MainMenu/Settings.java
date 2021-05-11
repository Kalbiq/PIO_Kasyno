package MainMenu;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Settings implements ChangeListener {

    private static final int WIDTH=1000;
    private static final int HEIGHT=600;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel settingsPanel;
    private static JPanel musicChoicePanel;
    private static JPanel musicVolumePanel;
    private static JPanel setDefaultFundsPanel;
    private static JPanel aboutCreatorsPanel;
    private static JLabel mainText;
    private static JLabel musicTextLabel;
    private static JLabel musicVolumeLabel;
    private static JButton musicListButton;
    private static JComboBox musicList;
    private static JSlider musicSlider;
    private static String[] music;

    private static JScrollPane sp;


    static{
        music=new String[]{"Nuta #1","Nuta #2","Nuta #3","Nuta #4"};
    }


    public void displaySettings()
    {

        EventQueue.invokeLater(() ->
        {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon icon= new ImageIcon(System.getProperty("user.dir")+"\\images\\iconBlackjack.png");



        frame=new JFrame("Kasyno Lichwiarz - Ustawienia");
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground( new Color(255, 167, 167) );

        mainPanel=new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,WIDTH,HEIGHT);
        mainPanel.setOpaque(false);


        mainText=new JLabel("USTAWIENIA");
        mainText.setBounds(325,5,350,100);
        mainText.setForeground(Color.white);
        mainText.setBackground(Color.black);
        mainText.setFont(new Font("MV Boli", Font.BOLD, 50));
        mainPanel.add(mainText);

        settingsPanel=new JPanel();
        settingsPanel.setBounds(250,100,500,400);
        settingsPanel.setBackground(Color.black);
        settingsPanel.setLayout(null);
        settingsPanel.setOpaque(false);

        musicChoicePanel=new JPanel();
        musicChoicePanel.setLayout(null);
        musicChoicePanel.setBounds(0,0,500,100);
        musicChoicePanel.setOpaque(false);
       // musicChoicePanel.setBackground(Color.green);

        musicTextLabel=new JLabel("Muzyka:");
        musicTextLabel.setBounds(0,0,100,100);
        musicTextLabel.setForeground(Color.white);
        musicTextLabel.setFont(new Font("MV Boli", Font.BOLD, 20));

        musicList=new JComboBox(music);
        musicList.setSelectedIndex(0);
        musicList.setBounds(100,25,175,50);

        musicListButton=new JButton("Wybierz");
        musicListButton.setBounds(300,25,175,50);

        musicChoicePanel.add(musicTextLabel);
        musicChoicePanel.add(musicList);
        musicChoicePanel.add(musicListButton);

        musicVolumePanel=new JPanel();
        musicVolumePanel.setLayout(null);
        musicVolumePanel.setBounds(0,100,500,100);
        musicVolumePanel.setOpaque(false);
       // musicVolumePanel.setBackground(Color.red);

        musicVolumeLabel=new JLabel("Glosnosc:");
        musicVolumeLabel.setBounds(0,0,200,100);
        musicVolumeLabel.setForeground(Color.white);
        musicVolumeLabel.setFont(new Font("MV Boli", Font.BOLD, 20));

        final int slider_MIN = 0;
        final int slider_MAX = 10;
        final int slider_INIT= 10;

        musicSlider=new JSlider(JSlider.HORIZONTAL,slider_MIN,slider_MAX,slider_INIT);

        musicSlider.addChangeListener(this);

        musicSlider.setMajorTickSpacing(10);
        musicSlider.setMinorTickSpacing(1);
        musicSlider.setBounds(100,40,200,50);
        musicSlider.setBackground(new Color(255, 167, 167));
        musicSlider.setForeground(Color.white);
        musicSlider.setPaintTicks(true);
        musicSlider.setPaintLabels(true);

        musicVolumePanel.add(musicVolumeLabel);
        musicVolumePanel.add(musicSlider);



        setDefaultFundsPanel=new JPanel();
        setDefaultFundsPanel.setLayout(null);
        setDefaultFundsPanel.setBounds(0,200,500,100);
        setDefaultFundsPanel.setOpaque(false);
        //setDefaultFundsPanel.setBackground(Color.blue);


        aboutCreatorsPanel=new JPanel();
        aboutCreatorsPanel.setLayout(null);
        aboutCreatorsPanel.setBounds(0,300,500,100);
        aboutCreatorsPanel.setOpaque(false);
        //aboutCreatorsPanel.setBackground(Color.yellow);

        settingsPanel.add(musicChoicePanel);
        settingsPanel.add(musicVolumePanel);
        settingsPanel.add(setDefaultFundsPanel);
        settingsPanel.add(aboutCreatorsPanel);


        mainPanel.add(settingsPanel);







        frame.add(mainPanel);



            musicListButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String music= Objects.requireNonNull(musicList.getSelectedItem()).toString();
                            PlayMusic.clip.stop();
                            try {
                                PlayMusic.playMusic(music);
                                PlayMusic.ChangeVolume(musicSlider.getValue());
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                                unsupportedAudioFileException.printStackTrace();
                            } catch (LineUnavailableException lineUnavailableException) {
                                lineUnavailableException.printStackTrace();
                            }


                        }

                    }
            );

        });

    }

    @Override
    public void stateChanged(ChangeEvent e) {

            PlayMusic.ChangeVolume(musicSlider.getValue());

    }
}
