import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class StartScreen extends JComponent
{
	private Painter p;//the background of the start screen
	public ClickBoxListener bl;//listens for mouse clicks on the start button
	private ClickBox c;//the start button
	
	//Constructor
	public StartScreen(Painter w)
	{
		p = w;
		c = new ClickBox(new Rectangle(200,300,200,100),
	       		 new int[]{273,355}, "Start", new Color[]{Color.WHITE,new Color(225,0,0)},
	       		 new Font("default", Font.BOLD, 22));
		bl = new ClickBoxListener(c.box);
		this.addMouseListener(bl);
	}
	
	//Paints the start screen
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		p.paintComponent(g);
		g.setColor(new Color(225,0,0));
		g.setFont(new Font("default",Font.BOLD,72));
		g.drawString("Super Javagon", 30, 60);
		g.setFont(new Font("default",Font.BOLD,18));
		g.drawString("by Chris Rosenberger, Vrushali Koli, Max Tootleman,"
				+ " and Tom Cuba", 0, 90);
		c.paintComponent(g);
	}
}
