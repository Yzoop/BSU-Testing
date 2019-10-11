package Lab1;

public class classTest {

    //Statics for test
    public static final String TEST_CORRECT_EDGE = "OK. Тест по сторонам пройден";
    public static final String TEST_CORRECT_PERIMETER = "OK.Тест по периметру пройден";
    public static final String TEST_CORRECT_AREA = "OK.Тест по площади пройден";
    public static final String TEST_INCORRECT_PERIMETER = "ОК(ОШИБОЧНЫЙ ТЕСТ)! Неверно просчитан периметр";
    public static final String TEST_INCORRECT_AREA = "ОК(ОШИБОЧНЫЙ ТЕСТ)! Неверно просчитана площадь";
    public static final String TEST_INCORRECT_EDGES = "ОШИБКА(ОШИБОЧНЫЙ ТЕСТ)! Невозможно создать треугольник с такими параметрами";
    public static final String TEST_CORRECT = "OK.Тест пройден";

    private final float PRECISION = 0.00001f;
    //Finished statics for test

    private short FirstEdge, SecondEdge, ThirdEdge;

    public static enum enTestType
    {
        eEdgeTester,
        ePerimeterTester,
        eAreaTester
    }

    private boolean TestCorrection;
    private enTestType TestType;
    private float testArea;
    //for tests
    private short testPerimeter,
                  testA, testB, testC;
    //
    private String TriangleData;


    public boolean Get_Test_Correction()
    {
        return TestCorrection;
    }

    public String Start_Test()
    {
        try {
            Triangle MyTrig = new Triangle(testA, testB, testC);
            switch (TestType) {
                case ePerimeterTester: {
                    if (testPerimeter == MyTrig.Get_Perimeter() && TestCorrection)
                        return TEST_CORRECT_PERIMETER;
                    else {
                        return TEST_INCORRECT_PERIMETER;
                    }
                }
                case eAreaTester: {
                    float trigArea = MyTrig.Get_Area();
                    if (Math.abs(testArea - MyTrig.Get_Area()) < PRECISION && TestCorrection)
                        return TEST_CORRECT_AREA;
                    else {
                        return TEST_INCORRECT_AREA;
                    }
                }
                case eEdgeTester: {
                    return TEST_CORRECT_EDGE;
                }
            }
        }
        catch(Exception ex)
        {
            if (!TestCorrection)
                return TEST_CORRECT_EDGE;
            else
                return TEST_INCORRECT_EDGES;
        }

        return "МЫ ЗДЕСЬ БЫТЬ НЕ ДОЛЖНЫ";
    }
    //if Start_Test() == Tes_Wrong => System

    //1 - correct;
    //0 - wrong.
    //Далее следуют типы теста
    //
    //%boolean_%enum_A_B_C_%Perimeter_%Area
    public classTest(String strTestLine) throws Exception
    {
        String TestLinePart[] = strTestLine.split(" ");

        TestCorrection = TestLinePart[0].equals("1");
        testA = Short.parseShort(TestLinePart[2]);
        testB = Short.parseShort(TestLinePart[3]);
        testC = Short.parseShort(TestLinePart[4]);

        switch (TestLinePart[1])
        {
            case "0":
                TestType = enTestType.eEdgeTester;
                break;
            case "1":
                TestType = enTestType.ePerimeterTester;
                testPerimeter = Short.parseShort(TestLinePart[5]);
                break;
            case "2":
                TestType = enTestType.eAreaTester;
                testArea = Float.parseFloat(TestLinePart[5]);
                break;
            default:
                throw new Exception("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAERROR_TEST_FORMAT");
        }
    }
}