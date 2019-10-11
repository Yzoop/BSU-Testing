package Lab1;

public class classTest {

    //Statics for test
    public static final String TEST_CORRECT = "OK. Тест пройден";
    public static final String TEST_WRONG = "ERROR! Тест не пройден";
    //Finished statics for test

    private short FirstEdge, SecondEdge, ThirdEdge;
    public enum enCorrection
    {
        eCorrect,
        eWrong
    }

    public enum enTestType
    {
        eCreateTester,
        eEdgeTester,
        ePerimeterTester,
        eAreaTester
    }

    private enCorrection TestCorrection;
    private enTestType TestType;

    public String Start_Test(Triangle atTriangle)
    {

    }

    //1 or 0 - eCorrect, eWrong соотвественно.
    //Далее следуют типы теста
    //
    public classTest(enCorrection correction, enTestType testType)
    {
        TestCorrection = correction;

    }
}