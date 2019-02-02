import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Wall extends JComponent
{
    private int radius;
    private int stick;//random int from 0-5 inclusive
    private final double INTERVAL = (Math.PI / 3); // 60 degrees in radians
    private final int WIDTH = 25;
    private int[] currentX;
    private int[] currentY;
    
    /*
     * @param int height and int m (stick number)
     */
    public Wall(int height, int m)
    {
        radius = height / 2;
        stick = m;
    }
    
    //@return radius
    public int getRadius()
    {
        return radius;
    }
    
    //@return stick
    public int getStick()
    {
        return stick;
    }
    
    //@param Graphics g
    //draws the trapezoid using fillPoygon and sets curretX to a and currentY to b
    public void paintComponent(Graphics g)
    {       
        super.paintComponent(g);
        int[] a = this.getXPoints(stick * 60 + Rotation.getOffset());
        int[] b = this.getYPoints(stick * 60 + Rotation.getOffset());
        g.setColor(Color.WHITE);
        g.fillPolygon(a, b, 4);    
        currentX = a;
        currentY = b;
    }
    
    //@return currentX    
    public int[] getCurrentX()
    {
        return currentX;
    }
    
    //@return currentY
    public int[] getCurrentY()
    {
        return currentY;
    }
    
    //@param double startAngle
    //@return the x-coordinates of the trapezoid 
    public int[] getXPoints(double startAngle)
    {
        startAngle = Math.toRadians(startAngle);
        int[] x = new int[4];
        double endAngle1 = startAngle + INTERVAL;
        int XCENTER = GameBoard.getFrame().getWidth()/2;
        
        x[0] = (int)((Math.cos(startAngle) * (radius - WIDTH) + XCENTER));
        x[1] = (int)((Math.cos(startAngle) * radius) + XCENTER);
        x[2] = (int)((Math.cos(endAngle1) * radius) + XCENTER);
        x[3] = (int)((Math.cos(endAngle1) * (radius - WIDTH) + XCENTER));
        currentX = x;
        return x;
    }
    
    //@param double startAngle
    //@return the y-coordinates of the trapezoid
    public int[] getYPoints(double startangle)
    {
        startangle = Math.toRadians(startangle);
        int[] y = new int[4];
        double endangle2 = startangle + INTERVAL;
        int YCENTER = GameBoard.getFrame().getHeight()/2;
        
        y[0] = (int)((Math.sin(startangle) * (radius - WIDTH) + YCENTER));
        y[1] = (int)((Math.sin(startangle) * radius) + YCENTER);
        y[2] = (int)((Math.sin(endangle2) * radius) + YCENTER);
        y[3] = (int)((Math.sin(endangle2) * (radius - WIDTH) + YCENTER));
        currentY = y;
        return y;
    }
    
    //@param Painter object
    //moves the trapezoid towards the center
    public static void moveTowardsCenter(Painter p)
    {
        if(p.layers[0].radius > 30)
            for(int i = 0; i < (10 + p.timer.getMillis() / 5000);i++)
                for(int j = 0; j < p.layers.length; j++)
                {    
                    p.layers[j].radius -= 1;
                    if(Collision.getFrontCollision(p.layers[j]))
                    {
                        GameBoard.setGameOver(true);
                        return;
                    }
                }
        else
            p.layers = Patterns.getWalls();
    }    
}
