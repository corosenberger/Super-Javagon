import java.io.File;
import java.nio.file.FileSystems;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds
{
    private static Clip player;
    
    //Makes an array of the wave files
    private static final File[] MUSIC = {new File("Menu Music.wav"), new File("Game Music I.wav"),
        new File("Game Music II.wav"), new File("Game Music III.wav")};
    
    public static void stop()
    {
        //stops the music player
        player.stop();
        player.close();
        player = null;
    }
    
    public static void playMusic(int m)
    {
        //starts the music
        try
        {
            player = AudioSystem.getClip();
            //opens the player with the file at m
            player.open(AudioSystem.getAudioInputStream(MUSIC[m]));
            player.start();
            //loops the music file
            player.loop(player.LOOP_CONTINUOUSLY);
        } 
        catch (Exception ex)
        {
            player = null;
        }
    }
}