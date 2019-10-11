package Lab1;

public class classTest {

    //Statics for test
    public static final String TEST_CORRECT_EDGE = "OK. Тест по сторонам пройден";
    public static final String TEST_CORRECT_PERIMETER = "OK.Тест по периметру пройден";
    public static final String TEST_CORRECT_AREA = "OK.Тест по площади пройден";
    public static final String TEST_INCORRECT_PERIMETER = "ОШИБКА! Неверно просчитан периметр";
    public static final String TEST_INCORRECT_AREA = "ОШИБКА! Неверно просчитана площадь";
    public static final String TEST_CORRECT = "OK.Тест пройден";
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


    public String Start_Test()
    {
        try {
            Triangle MyTrig = new Triangle(testA, testB, testC);

            switch (TestType) {
                case ePerimeterTester: {
                    if (testPerimeter == MyTrig.Get_Perimeter())
                        return TEST_CORRECT_PERIMETER;
                    else {
                        return TEST_INCORRECT_PERIMETER;
                    }
                }
                case eAreaTester: {
                    if (testArea == MyTrig.Get_Area())
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
            return ex.toString();
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
        testPerimeter = Short.parseShort(TestLinePart[5]);

        switch (TestLinePart[1])
        {
            case "0":
                TestType = enTestType.eEdgeTester;
                break;
            case "1":
                TestType = enTestType.ePerimeterTester;
                break;
            case "2":
                TestType = enTestType.eAreaTester;
                break;
            default:
                throw new Exception("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAERROR_TEST_FORMAT");
        }
    }
}