public class Rotation
{
    public static final double RATE = 2.5; //rate at which the game spins
    private static double offset; //how much the game has spun
    
    public static void rotate(int d)
    {
        if(d > 0)
        {
            offset += RATE;
            CharacterComponent.setAngle(CharacterComponent.getAngle()
            		- Math.toRadians(RATE));
            CenterShape.setAngle(CenterShape.getAngle() + Math.toRadians(RATE));
        }
        else if(d < 0)
        {
            offset -= RATE;
            CharacterComponent.setAngle(CharacterComponent.getAngle()
            		+ Math.toRadians(RATE));
            CenterShape.setAngle(CenterShape.getAngle() - Math.toRadians(RATE));
        }
        
        //keeps the offset in between 0 and 360 degress
        if(offset < 0)
            offset += 360;
        else
            offset %= 360;
    }
    
    //gets the offset
    public static double getOffset()
    {
        return offset;
    }
}
