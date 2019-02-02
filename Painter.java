import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Painter extends JComponent
{
    //All the things
    public CharacterComponent character;
    public Wall[] layers;
    public GameTimer timer;
    public CenterShape hex;
    public BackgroundScreen back;
    
    //Constructor
    public Painter(CharacterComponent c, Wall[] w, GameTimer t, CenterShape s, BackgroundScreen b)
    {
        character = c;
        layers = w;
        timer = t;
        hex = s;
        back = b;
    }
    
    //Paints all the things on the JFrame
    public void paintComponent(Graphics g)
    {
        back.paintComponent(g);
        character.paintComponent(g);
        for(int i = 0;i < layers.length;i++)
            layers[i].paintComponent(g);
        timer.paintComponent(g);
        hex.paintComponent(g);
    }
}
