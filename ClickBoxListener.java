import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickBoxListener implements MouseListener
{
    private Rectangle bounds; //the box the listener listens for
    public boolean hasBeenClicked; //whether or not the box has been clicked
    
    //Constructor
    public ClickBoxListener(Rectangle b)
    {
        bounds = b;
    }
    
    //sets has been clicked to true or false based on where the click was
    public void mouseClicked(MouseEvent e)
    {
        hasBeenClicked = bounds.contains(e.getPoint());
    }

    //so the class compiles
    public void mouseEntered(MouseEvent e)
    {
        //empty
    }

    //so the class compiles
    public void mouseExited(MouseEvent e)
    {
        //empty
    }

    //so the class compiles
    public void mousePressed(MouseEvent e)
    {
        //empty
    }

    //so the class compiles
    public void mouseReleased(MouseEvent e)
    {
        //empty
    }
}
