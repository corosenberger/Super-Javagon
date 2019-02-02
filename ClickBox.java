import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


@SuppressWarnings("serial")
public class ClickBox extends JComponent
{
	public Rectangle box;//the actual box
	public int[] pos; //position of the text
	public String text; //the text in the box
	public Color[] boxColors; //colors of the box and its text
	public Font style;//the font of the text
	
	//constructor
	public ClickBox(Rectangle b, int[] p, String t, Color[] bc, Font s)
	{
		box = b;
		pos = p;
		text = t;
		boxColors = bc;
		style = s;
	}
	
	//paints the box based on the variables
	public void paintComponent(Graphics g)
	{
		g.setColor(boxColors[0]);
		g.fillRoundRect(box.x, box.y, box.width, box.height, box.width / 4, box.height / 4);
		g.setColor(Color.ORANGE);
		g.drawRoundRect(box.x, box.y, box.width, box.height, box.width / 4, box.height / 4);
		g.setColor(boxColors[1]);
		g.setFont(style);
		g.drawString(text, pos[0], pos[1]);
	}
}
