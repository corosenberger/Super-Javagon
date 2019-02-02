import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameBoard
{   
    private static JFrame board;
    private static Timer t1, t2, t3, t4;
    private static boolean isHittingSide = false;
    private static boolean gameOver;
    private static int direction = 1;
    private static Painter p = new Painter(new CharacterComponent(Color.WHITE),
               new Wall[]{new Wall(800,2), new Wall(800,4), new Wall(800, 6)},
               new GameTimer(), new CenterShape(Color.WHITE), new BackgroundScreen());
    private static StartScreen start = new StartScreen(p);
    private static EndScreen end;
    
    /*
     * This is the main methods that calls the other components and runs the game
     */
    public static void main(String[] args)
    {
         board = new JFrame();
         board.setSize(600, 600);
         board.setResizable(false);
         board.setTitle("Super Javagon");
         board.setBackground(Color.BLACK);
         board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         p.back.updateColors(p);
         board.setContentPane(start);
         board.setVisible(true);
         board.addKeyListener(new GameListener());
         Sounds.playMusic(0);
         //Plays the actual Game
         t1 = new Timer(30, new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                isHittingSide = false;
                Rotation.rotate(direction);
                CenterShape.pulse();
                //p.back.updateColors(p);
                GameBoard.doCharacterAndCollision();
                if(!gameOver)
                    Wall.moveTowardsCenter(p);
                if(gameOver || GameListener.spacePressed)
                {
                    t1.stop();
                    p.timer.stop();
                    end = new EndScreen(p);
                    board.setContentPane(end);
                    board.setVisible(true);
                    t4.start();
                    Sounds.stop();
                    Sounds.playMusic(0);
                    gameOver = false;
                    return;   
                }
                board.repaint();
             }
         });
         
         //plays StartScreen
         t2 = new Timer(30, new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                Rotation.rotate(direction);
                CenterShape.pulse();
                //p.back.updateColors(p);
                if(start.bl.hasBeenClicked || GameListener.enterPressed)
                {
                    board.setContentPane(p);
                    board.setVisible(true);
                    t1.start();
                    p.timer.start();
                    t2.stop();
                    Sounds.stop();
                    Sounds.playMusic((int)(Math.random() * 3 + 1));
                }
                board.repaint();
             }
         });
         
         //plays Rotation
         t3 = new Timer(6000, new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                direction *= -1;
             }
         });
         
         //plays EndScreen
         t4 = new Timer(30, new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                Rotation.rotate(direction);
                CenterShape.pulse();
                //p.back.updateColors(p);
                if(end.bl1.hasBeenClicked || GameListener.enterPressed)
                {          
                    p = new Painter(new CharacterComponent(Color.WHITE),
                              new Wall[]{new Wall(800,2), new Wall(800,4), new Wall(800, 6)},
                              new GameTimer(), new CenterShape(Color.WHITE), new BackgroundScreen());
                    p.back.updateColors(p);
                    CharacterComponent.setAngle(Math.toRadians(270)
                            - Math.toRadians(Rotation.getOffset()));
                    board.setContentPane(p);
                    board.setVisible(true);
                    Patterns.reset();
                    t1.start();
                    p.timer.start();
                    end.bl1.hasBeenClicked = false;
                    Sounds.stop();
                    Sounds.playMusic((int)(Math.random() * 3 + 1));
                    t4.stop();
                }
                else if(end.bl2.hasBeenClicked || GameListener.backspacePressed)
                {
                    System.exit(0);
                }
                board.repaint();
             }
         });
         t2.start();
         t3.start();
    }
    
    //@return the JFrame board
    public static JFrame getFrame()
    {
        return board;
    }
    
    //@param boolean g
    //sets the gameOver field to g
    public static void setGameOver(boolean g)
    {
        gameOver = g;
    }
    
    //moves the character based on which key was pressed while doing collision
    private static void doCharacterAndCollision()
    {
        if (GameListener.leftPressed && !isHittingSide)
        {
            for(int i = 0; i < 30; i++)
            {
                for(int j = 0; j < p.layers.length; j++)
                     if(Collision.getSideCollision(p.layers[j]))
                     {
                         isHittingSide = true;
                         break;
                     }
                     else if(Collision.getFrontCollision(p.layers[j]))
                    {
                        GameBoard.setGameOver(true);
                        return;
                    }
                if(isHittingSide)
                    break;
                CharacterComponent.setAngle(CharacterComponent.getAngle()
                    + Math.toRadians(.5));
            }
        }
        else if (GameListener.rightPressed && !isHittingSide)
        {
            for(int i = 0; i < 30; i++)
            {
               for(int j = 0; j < p.layers.length; j++)
                    if(Collision.getSideCollision(p.layers[j]))
                    {
                        isHittingSide = true;
                        break;
                    }
                    else if(Collision.getFrontCollision(p.layers[j]))
                    {
                        GameBoard.setGameOver(true);
                        return;
                    }
               if(isHittingSide)
                   break;
               CharacterComponent.setAngle(CharacterComponent.getAngle()
                       - Math.toRadians(.5));
            }
        }
        for(int i = 0; i < p.layers.length;i++)
            if(Collision.getFrontCollision(p.layers[i]))
            {
                GameBoard.setGameOver(true);
                return;
            }
    }
}

