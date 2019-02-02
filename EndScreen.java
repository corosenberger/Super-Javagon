import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class EndScreen extends JComponent
{
	private Painter p; //background
	public ClickBoxListener bl1, bl2; //MouseListeners for the reset and exit buttons
	private ClickBox c1, c2; //The reset and exit buttons
	private ScoreBoard s; //The highscore
	
	//Constructor
	public EndScreen(Painter w)
	{
		p = w;
		c1 = new ClickBox(new Rectangle(50,300,200,100),
	       		 new int[]{119,355}, "Reset", new Color[]{Color.WHITE,new Color(225,0,0)},
	       		 new Font("default", Font.BOLD, 22));
		c2 = new ClickBox(new Rectangle(350,300,200,100),
	       		 new int[]{429,355}, "Exit", new Color[]{Color.WHITE,new Color(225,0,0)},
	       		 new Font("default", Font.BOLD, 22));
		bl1 = new ClickBoxListener(c1.box);
		bl2 = new ClickBoxListener(c2.box);
		s = new ScoreBoard(w.timer);
		this.addMouseListener(bl1);
		this.addMouseListener(bl2);
	}
	
	//Paints the game over screen
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		p.paintComponent(g);
		g.setColor(new Color(225,0,0));
		g.setFont(new Font("default",Font.BOLD,72));
		g.drawString("Game Over", 95, 60);
		s.paintComponent(g);
		c1.paintComponent(g);
		c2.paintComponent(g);
	}
}
