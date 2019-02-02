import java.awt.Polygon;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
public class BackgroundScreen extends JComponent
{
    private Polygon[] background = new Polygon[6]; // Array containing the six segments of the
        //background
    private Color[] colors = new Color[6]; // Array containing the colours of the six segments of the
        //background. They each correspond to a segment
    //Gets the x values of the six points of a segment built around the angle parameter
    int[] getXPoints(double startAngle)
    {
        startAngle = Math.toRadians(startAngle);
        int[] x = new int[4];
        double endAngle1 = startAngle + Math.toRadians(60);
        int XCENTER = GameBoard.getFrame().getWidth()/2;
        
        x[0] = (int)((Math.cos(startAngle) * (-GameBoard.getFrame().getWidth()) + XCENTER));
        x[1] = (int)((Math.cos(startAngle)+ XCENTER));
        x[2] = (int)((Math.cos(endAngle1) + XCENTER));
        x[3] = (int)((Math.cos(endAngle1) * (-GameBoard.getFrame().getWidth()) + XCENTER));
        return x;
    }
    //Gets the y values of the six points of a segment built around the angle parameter
    public int[] getYPoints(double startangle)
    {
        startangle = Math.toRadians(startangle);
        int[] y = new int[4];
        double endangle2 = startangle + Math.toRadians(60);
        int YCENTER = GameBoard.getFrame().getHeight()/2;
        
        y[0] = (int)((Math.sin(startangle) * (-GameBoard.getFrame().getHeight()) + YCENTER));
        y[1] = (int)(Math.sin(startangle) + YCENTER);
        y[2] = (int)(Math.sin(endangle2) + YCENTER);
        y[3] = (int)((Math.sin(endangle2) * (-GameBoard.getFrame().getHeight()) + YCENTER));
        return y;
    }
   //Changes the background colours at a fixed time interval (in this case, two seconds)
   public void updateColors(Painter p)
   {
       for(int i = 0; i < background.length; i++) {
        if((p.timer.getMillis() / 2000) % 2 < 1) {
            if(i % 2 == 0)
                colors[i] = Color.BLACK;
            else
                colors[i] = Color.DARK_GRAY;
        }
        else { // Effectively swaps the colours of all of the walls (grey becomes black, black becomes grey)
            if(i % 2 == 0)
                colors[i] = Color.DARK_GRAY;
            else
                colors[i] = Color.BLACK;
        }
        }
   }
   //Adds the six segments of the background into the array of Polygons, then draws them with their corresponding
   //colours according to the array of Colors
    public void paintComponent(Graphics g) 
    {
        for(int i = 0; i < background.length; i++)
            background[i] = new Polygon(this.getXPoints(i * 60 + Rotation.getOffset()),
                this.getYPoints(i * 60 + Rotation.getOffset()), 4);
        for(int i = 0; i < background.length; i++) {
            g.setColor(colors[i]);
            g.fillPolygon(background[i]);
        }
   }
}
