public class Patterns
{
    //The pats array. Each pattern is a 2d array, filled with 1d arrays that represent "sticks"
    //that walls are created on. The 1d arrays create sets of walls that spawn in set intervals.
    //pats holds multiple of these "patterns", making it a 3d array 
    private static int[][][]pats = {
        {{0, 2, 4}, {1, 3, 5}, {0, 2, 4}, {1, 3, 5}},
        {{1, 2, 3, 4, 5}, {0, 1, 2, 4, 5}, {1, 2, 3, 4, 5}, {0, 1, 2, 4, 5}, {1, 2, 3, 4, 5}},
        {{1,6},{2,5},{3,4},{1,5},{2,4},{1,3,4,5,6}},
        {{1,2,4}, {3,4,6}, {1,5,6}, {2,3,4}, {2,3,5,6}},
        {{1,2,3,5}, {2,4,5,6}, {1,2,5,6}, {1,3,5,6}, {1,2,3,4,5}},
        {{1,3,5},{1,2,4,5},{2,3,4,5,6},{2,3,5,6},{2,4,6}},
        {{1,4},{2,4,6},{1,2,4,5,6},{1,3,5},{6,3}},
        {{1,3,4,6},{2,3,5,6},{1,2,4,5},{1,3,4,6},{1,2,3,4,5}}
    };
    private static int currentPattern; //The current pattern (Index of the 2d array being used)
    private static int currentWall; //The current wall(Index of the 1d array being used)
    
    //Gets the walls that should generate based on the currently selected pattern and wall
    public static Wall[] getWalls()
    {
        Wall[] layers = new Wall[pats[currentPattern][currentWall].length];
        for(int i = 0; i < pats[currentPattern][currentWall].length;i++)
            layers[i] = new Wall(1000,pats[currentPattern][currentWall][i]);
        Patterns.swapWall();
        return layers;
    }
    
    //Resets the wall and pattern choices
    public static void reset()
    {
        currentPattern = 0;
        currentWall = 0;
    }
    
    //Advances through the walls in the chosen pattern
    private static void swapWall()
    {
        if(currentWall < pats[currentPattern].length - 1)
            currentWall++;
        else
        {
            Patterns.swapPattern();
            currentWall = 0;
        }
    }
    
    //Randomly chooses a pattern from pats
    private static void swapPattern()
    {
        int n = currentPattern;
        while(n == currentPattern)
            currentPattern = (int)(Math.random() * pats.length);
    }
}


