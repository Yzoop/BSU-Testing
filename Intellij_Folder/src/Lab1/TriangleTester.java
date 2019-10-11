package Lab1;

import com.sun.source.tree.ClassTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TriangleTester {

    public static void Start_Testing()
    {
        String Line;
        Scanner streamReader;
        try
        {
            File file = new File("test.txt");
            streamReader = new Scanner(file);
            while(streamReader.hasNext())
            {
                classTest MyClassTest = new classTest(streamReader.nextLine()) ;
                System.out.println(MyClassTest.Start_Test());
            }
        }
        catch(Exception ex)
        {
            System.out.printf("Ошибка чтения файла:%s\n", ex);
        }
    }

    public static void main(String args[])
    {
        Start_Testing();
    }
}
