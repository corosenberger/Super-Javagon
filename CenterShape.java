import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class CenterShape extends JComponent 
{
    private static int radius = 50; // Distance of the edges from the center of the screen
    private static long direction = -1;//How many pixels the CenterShape moves per frame when it pulses
    private static double angle = Math.toRadians(0); //The angle at which the CenterShape is tilted
    private Color shapeColor; //Colour of the shape
    
    //Constructs a CenterShape of a specific colour
    public CenterShape(Color c) 
    {
        shapeColor = c;
    }
    //Generates the x and y values for the six points on the CenterShape and fills them, creating a hexagon.
    public void paintComponent(Graphics g)
    {
        g.setColor(shapeColor);
        int xCenter = (GameBoard.getFrame().getWidth() / 2);
        int yCenter = (GameBoard.getFrame().getHeight() / 2);
        int[][]xy = new int[2][6];
        for(int i = 0; i < 6; i++)
        {
            xy[0][i] = (int)(xCenter + radius * (Math.cos(i * Math.toRadians(60) + angle)));
            xy[1][i] = (int)(yCenter + radius * (Math.sin(i * Math.toRadians(60) + angle)));
        }
        g.fillPolygon(xy[0], xy[1], 6);
    }
    //Resizes the CenterShape. Purely aesthetic and is called every tick/frame
    public static void pulse()
    {
        radius += direction;
        if(radius >= 50)
            direction = -1;
        else if(radius <= 45)
            direction = 1;
    }
    //Modifier for the angle field
    public static void setAngle(double n)
    {
        angle = n;
    }
    //Accessor for the angle field
    public static double getAngle()
    {
        return angle;
    }
}

