package Lab6_3;

public class MainXY {

    private static final int LINE_START       = 3,
                             LINE_FINISH      = 6,
                             XOR_NEGATIVE_INC = 3,
                             LINE_DEC         = 10,
                             ELSE_MULT = 2;





    private static boolean isOutOfSquare(Pair p)
    {
        return  (p.getX() < LINE_START || p.getX() > LINE_FINISH) &&
                (p.getY() < LINE_START || p.getY() > LINE_FINISH);
    }


    public static Pair calculatePair(Pair pair)
    {
        if (pair.getX() < 0 && pair.getY() < 0)
        {
            return new Pair(Math.abs(pair.getX()), Math.abs(pair.getY()));
        }
        else if (pair.getX() < 0 ^ pair.getY() < 0)
        {
            return new Pair(pair.getX() + XOR_NEGATIVE_INC, pair.getY() + XOR_NEGATIVE_INC);
        }
        else if (pair.getX() >= 0 && pair.getY() >= 0 && isOutOfSquare(pair))
        {
            return new Pair(pair.getX() - LINE_DEC, pair.getY() - LINE_DEC);
        }
        else //other cases
        {
            return new Pair(pair.getX() * ELSE_MULT, pair.getY() * ELSE_MULT);
        }
    }



}
