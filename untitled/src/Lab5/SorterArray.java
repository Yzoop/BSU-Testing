package Lab5;

import java.util.LinkedList;

public class SorterArray {

    public static Integer[] selectionSort(Integer[] arr)
    {
        for (int min = 0; min < arr.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }

            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;
        }

        return arr;
    }
}
