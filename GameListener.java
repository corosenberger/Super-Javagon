import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener
{    
    public static boolean enterPressed = false;
    public static boolean backspacePressed = false;
    public static boolean spacePressed = false;
    public static boolean leftPressed = false;
    public static boolean rightPressed = false;
    
    //sets a variable to true base on which key was press
    public void keyPressed(KeyEvent e)
    {
        int n = e.getKeyCode();
        switch(n)
        {
            case 10:
                enterPressed = true;
                break;
            case 8:
                backspacePressed = true;
                break;
            case 32:
                spacePressed = true;
                break;
            case 37:
                leftPressed = true;
                break;
            case 39:
                rightPressed = true;
                break;
        }
    }

    //Makes the variables false
    public void keyReleased(KeyEvent e)
    {
        enterPressed = false;
        backspacePressed = false;
        spacePressed = false;
        leftPressed = false;
        rightPressed = false;
    }

    //so the class compiles
    public void keyTyped(KeyEvent e)
    {
        //empty
    }
}