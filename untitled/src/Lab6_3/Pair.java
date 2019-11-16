package Lab6_3;

public class Pair {
    private int X;
    private int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Pair(int x, int y) {
        X = x;
        Y = y;
    }
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair oAsPair = (Pair)o;
        return X == oAsPair.getX() && Y == oAsPair.getY();
    }
}
