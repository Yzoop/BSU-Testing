package Lab5;


import java.io.File;
import java.util.*;

public class ReaderArray {

    private static Integer counter = 0;
    private static boolean isFileRead = false;

    public static LinkedList<Integer[]> LL_testers = new LinkedList<Integer[]>();


    public static Integer[] getNextTest() throws Exception
    {
        if (!isFileRead)
            startReading();
        if (counter < LL_testers.size())
        {
            return LL_testers.get(counter++);
        }
        else
            {
            throw new Exception("Doesn't have next!");
        }
    }


    private static Integer[] parseArray(String str)
    {
        Integer[] llToReturn;
        String[] values = str.split(" ");
        llToReturn = new Integer[values.length];
        for(int i = 0; i < values.length; i++)
        {
            llToReturn[i] = Integer.parseInt(values[i]);
        }

        return llToReturn;
    }


    public static void startReading()
    {
        try{
            Scanner in = new Scanner(new File("arrays.in"));
            while(in.hasNextLine())
            {
                LL_testers.add(parseArray(in.nextLine()));
            }
            isFileRead = true;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }


}
