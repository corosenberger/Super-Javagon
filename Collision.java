import java.awt.Point;
import java.awt.Polygon;

public class Collision
{
    private static Polygon bounds; // Holds the bounds of the walls being passed into the methods
    //Checks to see if the tip of the triangle is hitting the wall parameter
    public static boolean getFrontCollision(Wall w)
    {
        try
        {
            bounds = new Polygon(w.getCurrentX(), w.getCurrentY(), 4);
            int[][] xy = CharacterComponent.getXY();
            return bounds.contains(new Point(xy[0][0],xy[1][0]));
        }
        catch(NullPointerException ex) //may throw a nullpointerexception
        {
            return false;
        }
    }
    //Checks to see if the side of the triangle is hitting the wall parameter
    public static boolean getSideCollision(Wall w)
    {
        try
        {
            bounds = new Polygon(w.getCurrentX(), w.getCurrentY(), 4);
            int[][] xy = CharacterComponent.getXY();
            return bounds.contains(new Point(xy[0][1],xy[1][1])) ||
                    bounds.contains(new Point(xy[0][2],xy[1][2]));
        }
        catch(NullPointerException ex)
        {
            return true;
        }
    }
}