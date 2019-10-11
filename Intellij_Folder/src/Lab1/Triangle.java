package Lab1;

public class Triangle {

    public static String ERROR_CREATE_TRIANGLE = "Ошибка формата треугольника";

    private short A, B, C;

    private short Perimeter = -1;

    private float Square = -1;

    public enum eTrigType
    {
        equilateral,
        isosceles,
        versatile
    }

    private boolean Ok_Size(final short _a, final short _b, final short _c)
    {
        if (_a > 0 && _b > 0 && _c > 0)
        {
            if (_a + _b > _c && _a + _c > _c && _b + _a > _c)
                return true;
        }

        return false;
    }

    public eTrigType Get_Type()
    {
        if (A == B && A == C && B == C)
        {
            return eTrigType.equilateral;
        }
        else if (A == B || A == C || C == B)
        {
            return eTrigType.isosceles;
        }
        else
            return eTrigType.versatile;
    }

    public short Get_Perimeter()
    {
        if (Perimeter == -1)
        {
            Perimeter = (short) (A + B + C);
        }

        return Perimeter;
    }

    public float Get_Square()
    {
        if (Square == -1)
        {
            Square = (float)Math.sqrt(Get_Perimeter() * (Get_Perimeter() - A) * (Get_Perimeter() - B) * (Get_Perimeter() - C));
        }

        return Square;
    }


    public Triangle(short a, short b, short c) throws Exception
    {
        if (Ok_Size(a, b, c))
        {   A = a;
            B = b;
            C = c;
        }
        else
            throw new Exception(ERROR_CREATE_TRIANGLE);
    }
}
