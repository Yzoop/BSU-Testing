package Lab6_3;

import java.util.Scanner;

import junit.framework.TestCase;
import org.junit.*;

public class JTester extends TestCase {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @Before
    public void initTest() {
    }

    @After
    public void afterTest() {
    }

//    @Test
//    public void oneNegative() throws Exception
//    {
//        assertEquals(MainXY.calculatePair(new Pair(125, -125)), new Pair(128, -122));
//    }


    @Test
    public void testOneNegative() throws Exception
    {
        Pair supposedAnswer = new Pair(128, -122);
        Pair answer = MainXY.calculatePair(new Pair(125, -125));
        assertEquals(answer, supposedAnswer);
    }


    @Test
    public void testBothNegative() throws Exception
    {
        assertEquals(MainXY.calculatePair(new Pair(-125, -125)), new Pair(125, 125));
    }


    @Test
    public void reversedOneNegative()
    {
        assertEquals(MainXY.calculatePair(new Pair(-125, 125)), new Pair(-122, -128));
    }



    @Test
    public void testBothZeros()
    {
        assertEquals(MainXY.calculatePair(new Pair(0, 0)), new Pair(-10, -10));
    }


    @Test
    public void testZeroOne()
    {
        assertEquals(MainXY.calculatePair(new Pair(0, 1)), new Pair(-10, -9));
    }


    @Test
    public void testOneZero()
    {
        assertEquals(MainXY.calculatePair(new Pair( 1, 0)), new Pair(-9, -10));
    }


    @Test
    public void testOneTwo()
    {
        assertEquals(MainXY.calculatePair(new Pair(1, 2)), new Pair(-9, -8));
    }


    @Test
    public void testTwoOne()
    {
        assertEquals(MainXY.calculatePair(new Pair(2, 1)), new Pair(-8, -9));
    }

    @Test
    public void testSevenEight()
    {
        assertEquals(MainXY.calculatePair(new Pair(7, 8)), new Pair(-3, -2));
    }

    @Test
    public void testEightSeven()
    {
        assertEquals(MainXY.calculatePair(new Pair(8, 7)), new Pair(-2, -3));
    }

    @Test
    public void testTwoThree()
    {
        assertEquals(MainXY.calculatePair(new Pair(2, 3)), new Pair(4, 6));
    }

    @Test
    public void testThreeTwo()
    {
        assertEquals(MainXY.calculatePair(new Pair(3, 2)), new Pair(6, 4));
    }

    @Test
    public void testThreeFour()
    {
        assertEquals(MainXY.calculatePair(new Pair(3, 4)), new Pair(6, 8));
    }

    @Test
    public void testFourThree()
    {
        assertEquals(MainXY.calculatePair(new Pair(4, 3)), new Pair(8, 6));
    }

    @Test
    public void testFiveFive()
    {
        assertEquals(MainXY.calculatePair(new Pair(5, 5)), new Pair(10, 10));
    }

    @Test
    public void testFiveSix()
    {
        assertEquals(MainXY.calculatePair(new Pair(5, 6)), new Pair(10, 12));
    }

    @Test
    public void testSixFive()
    {
        assertEquals(MainXY.calculatePair(new Pair(6, 5)), new Pair(12, 10));
    }

    @Test
    public void testThreeSix_LineBorders()
    {
        assertEquals(MainXY.calculatePair(new Pair(3, 6)), new Pair(6, 12));
    }

    @Test
    public void reversedTestSixThree_LineBorders()
    {
        assertEquals(MainXY.calculatePair(new Pair(6, 3)), new Pair(12, 6));
    }

    @Test
    public void testSixSeven()
    {
        assertEquals(MainXY.calculatePair(new Pair(6, 7)), new Pair(12, 14));
    }

    @Test
    public void testSevenSix()
    {
        assertEquals(MainXY.calculatePair(new Pair(7, 6)), new Pair(14, 12));
    }

    @Test
    public void testThreeThree_LeftMargin()
    {
        assertEquals(MainXY.calculatePair(new Pair(3, 3)), new Pair(6, 6));
    }

    @Test
    public void testSixSix_RightMargin()
    {
        assertEquals(MainXY.calculatePair(new Pair(6, 6)), new Pair(12, 12));
    }

}
