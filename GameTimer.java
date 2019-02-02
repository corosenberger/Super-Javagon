import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class GameTimer extends JComponent
{
    private long time;
    private long startTime;
    private boolean isRunning;
    
    public void start()
    {
        //starts the timer
        isRunning = true;
        startTime = System.currentTimeMillis();
    }
    
    public void stop()
    {
        //stops the timer
        isRunning = false;
    }
    
    private void updateClock()
    {
        //sets the to the current amount of time that has elapsed
        if(isRunning)
            time = System.currentTimeMillis() - startTime;
    }
    
    public String getTime()
    {
        //returns a String with the time as format    00:00.000
        this.updateClock();
        long min = time / 60000;
        long sec = time % 60000 / 1000;
        long tenths = time % 60000 % 1000;
        String clock = "";
        if(min < 10)
            clock += "0";
        clock += min + ":";
        if(sec < 10)
            clock += "0";
        clock += sec + ".";
        if(tenths < 100)
            clock += "0";
        clock += tenths;
        if(clock.length() == 8)
            clock += "0";
        return clock;
    }
    
    public long getMillis()
    {
        //calls updateClock() and returns the time
        this.updateClock();
        return time;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("default", Font.BOLD, 22));
        g.drawString("Time: " + this.getTime(), GameBoard.getFrame().getWidth() - 170, 25);
    }
}

