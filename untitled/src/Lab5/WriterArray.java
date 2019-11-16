package Lab5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

public class WriterArray {

    public static void fileWrite(LinkedList<Integer> llToWriter)
    {
        try {
            FileWriter fWriter = new FileWriter(new File("sorted.out"));
            fWriter.append(fWriter.toString());
            fWriter.append("\n");
            fWriter.flush();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

}
