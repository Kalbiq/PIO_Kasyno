package mainmenuTests;

import MainMenu.PlayMusic;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.*;


import java.io.IOException;

import static MainMenu.PlayMusic.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class playMusicTest {

    public static Clip clip;

    @Test
    public void checkReduceVolume_correctResult(){

        //given
        int basicReduceVolume=0;

        //when
        int result= PlayMusic.returnReduceVolume();

        //then
        assertEquals(0,result);

    }

    @Test
    public void checkPlayMusicSwitch_correctResult() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //given
        String musicName="Nuta #2";
        String musicPath;

        //when
        musicPath=playMusic(musicName);

        //then
        assertEquals(System.getProperty("user.dir")+"\\music\\2_Tygodnie_do_matury.wav",musicPath);
    }

    @Test
    public void checkPlayMusicSwitchDefault_correctResult() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //given
        String musicName="Taka Muzyka Nie Istnieje";
        String musicPath;

        //when
        musicPath=playMusic(musicName);

        //then
        assertEquals(System.getProperty("user.dir")+"\\music\\Tentin_Quarantino_Day_1.wav",musicPath);
    }

}
