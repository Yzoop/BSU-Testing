package Lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import junit.framework.TestCase;
import org.junit.*;



public class JSortingTester extends TestCase {


    @BeforeClass
    public static void beforeClass()
    {
        ReaderArray.startReading();
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


    public static boolean isEqual(Integer[] first, Integer[] second)
    {
        return Arrays.equals(first, second);
    }


    @Test
    public void testFirst() throws Exception
    {
        Integer arrCorrect[] = {2, 3, 4, 5, 6, 7};
        Integer arrToTest[] = SorterArray.selectionSort(ReaderArray.getNextTest());
        assertEquals(true, isEqual(arrCorrect, arrToTest));
    }


    @Test
    public void testSecond() throws Exception
    {
        Integer arrCorrect[] = {5, 18, 4, 3, 2, 7};
        Integer arrToTest[] = SorterArray.selectionSort(ReaderArray.getNextTest());
        assertEquals(true, isEqual(arrCorrect, arrToTest));
    }

}
