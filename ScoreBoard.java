import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JComponent;

public class ScoreBoard extends JComponent
{
    private String label;
    private static final long serialVersionUID = 1L;
    
    public ScoreBoard(GameTimer t)
    {
        String highscore = t.getTime();
        
        // This will reference one line at a time
        String line = "";
        Scanner s = null;
        try
        {
            // BufferedReader and Scanner read the text file.
            s = new Scanner(new File("highscore.txt"));
            while (s.hasNext())
                line += s.next();
            if (s != null)
                s.close();
        
            String score = line;
            
            //compares the highscre and current score
            if(highscore.compareTo(score) < 0)
            {
                highscore = score;
            }
            
            //Writes over the file with the highest score
            BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"));
            writer.write(highscore);
            writer.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable TO OPEN file 'highscore.txt'");
        }
        catch(IOException ex)
        {
           System.out.println("ERROR reading file 'highscore.txt'");
        }
        
        label = highscore;
        
        if(highscore.equals(t.getTime()))
            label += " NEW!";
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("default", Font.BOLD, 22));
        g.drawString("High Score: " + label, 95, 90);
    }
}