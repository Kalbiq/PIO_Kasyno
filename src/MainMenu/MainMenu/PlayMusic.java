package MainMenu;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PlayMusic {

    public static void playMusic(int game) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        String musicPath;

        switch(game)
        {
            case 0:
            {
                musicPath=System.getProperty("user.dir")+"\\music\\Tentin_Quarantino_Day_1.wav";
                break;
            }
            case 1:
            {
                musicPath=System.getProperty("user.dir")+"\\music\\2_Tygodnie_do_matury.wav";
                break;
            }
            case 2:
            {
                musicPath=System.getProperty("user.dir")+"\\music\\Lonely_Night_In_Kalina.wav";
                break;
            }
            case 3:
            {
                musicPath=System.getProperty("user.dir")+"\\music\\Jaki_zastosujemy_rodzaj_dystrybucji_przy_sprzedazy_pieczywa.wav";
                break;
            }
            default:
                musicPath=System.getProperty("user.dir")+"\\music\\Tentin_Quarantino_Day_1.wav";
        }

        File musicFile = new File(musicPath);

        if(musicFile.exists())
        {
            AudioInputStream audioInput= AudioSystem.getAudioInputStream(musicFile);
            Clip clip= AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }


    }

}
