import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class CharacterComponent extends JComponent
{
    private static final int RADIUS = 60; //how far the character is from the center
    private static final double BASE = 10; //base of the triangular character
    private static double angle = Math.toRadians(270); // angle on the unit circle
    private Color characterColor; //color of the character
    
    //Constructor
    public CharacterComponent(Color c)
    {
        characterColor = c;
    }
    
    //paints the character
    public void paintComponent(Graphics g)
    {
        int[][] xy = CharacterComponent.getXY();
        g.setColor(characterColor);
        g.fillPolygon(xy[0],xy[1],3);
    }
    
    //sets the color of the character
    public void setColor(Color c)
    {
        characterColor = c;
    }
    
    //gets angle
    public static double getAngle()
    {
        return angle;
    }
    
    //sets angle and makes sure it is in between 0 and 360 degrees
    public static void setAngle(double a)
    {
        angle = a;
        if(angle < 0)
            angle += Math.toRadians(360);
        else
            angle %= Math.toRadians(360);
    }
    
    //returns RADIUS
    public static int getRadius()
    {
        return RADIUS;
    }
    
    //returns the coordinates for the character in a 2-D array
    public static int[][] getXY()
    {
        int[][] xy = new int[2][3];
        double a = angle % Math.toRadians(90);
        int xCenter = (GameBoard.getFrame().getWidth() / 2);
        int yCenter = (GameBoard.getFrame().getHeight() / 2);
        double h = Math.sqrt(BASE * BASE - (BASE / 2) * (BASE / 2));
        if(angle >= Math.toRadians(270))
        {
            xy[0][0] = (int)(xCenter + (Math.sin(a) * (RADIUS + h)));
            xy[0][1] = (int)(xCenter + (Math.sin(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[0][2] = (int)(xCenter + (Math.sin(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][0] = (int)(yCenter + (Math.cos(a) * (RADIUS + h)));
            xy[1][1] = (int)(yCenter + (Math.cos(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][2] = (int)(yCenter + (Math.cos(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
        }
        else if(angle >= Math.toRadians(180))
        {
            xy[0][0] = (int)(xCenter - (Math.cos(a) * (RADIUS + h)));
            xy[0][1] = (int)(xCenter - (Math.cos(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[0][2] = (int)(xCenter - (Math.cos(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][0] = (int)(yCenter + (Math.sin(a) * (RADIUS + h)));
            xy[1][1] = (int)(yCenter + (Math.sin(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][2] = (int)(yCenter + (Math.sin(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
        }
        else if(angle >= Math.toRadians(90))
        {
            xy[0][0] = (int)(xCenter - (Math.sin(a) * (RADIUS + h)));
            xy[0][1] = (int)(xCenter - (Math.sin(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[0][2] = (int)(xCenter - (Math.sin(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][0] = (int)(yCenter - (Math.cos(a) * (RADIUS + h)));
            xy[1][1] = (int)(yCenter - (Math.cos(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][2] = (int)(yCenter - (Math.cos(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
        }
        else
        {
            xy[0][0] = (int)(xCenter + (Math.cos(a) * (RADIUS + h)));
            xy[0][1] = (int)(xCenter + (Math.cos(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[0][2] = (int)(xCenter + (Math.cos(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][0] = (int)(yCenter - (Math.sin(a) * (RADIUS + h)));
            xy[1][1] = (int)(yCenter - (Math.sin(a + Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
            xy[1][2] = (int)(yCenter - (Math.sin(a - Math.atan((BASE / 2) / RADIUS))
                    * Math.sqrt(RADIUS * RADIUS + (BASE / 2) * (BASE / 2))));
        }
       
        return xy;
    }
}
