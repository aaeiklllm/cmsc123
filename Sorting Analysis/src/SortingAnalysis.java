import java.io.*;
import java.util.*;

/**
 * Compares the running times of sorting algorithms
 * @author bryann
 *
 */
public class SortingAnalysis {
    public static void insertionSort(String[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            String cur = a[i];
            int j = i - 1;
            while((j >= 0) && (a[j].compareTo(cur) > 0)) {
                a[j + 1] = a[j--];
            } // end while
            a[j + 1] = cur;
        } // end for
    } // end insertionSort

    public static void mergeSort(String[] array){
        int arraySize = array.length;

        if (arraySize > 1){
            int midIndex = arraySize / 2;
            String[] leftHalf = new String[midIndex];
            String[] rightHalf = new String[arraySize - midIndex];

        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < arraySize; i++){
            rightHalf[i - midIndex] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
        }
    }

    public static void merge(String[] array, String[] leftHalf, String[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize){
            int comparedResult = leftHalf[i].compareTo(rightHalf[j]);

            if (comparedResult <= 0){
                array[k] = leftHalf[i];
                i++;
            }
            else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize){ //remaining elements
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize){
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        final int NO_OF_WORDS = 50000;
        try {
            Scanner file = new Scanner(new File(args[0]));
            String[] words = new String[NO_OF_WORDS];

            int i = 0;
            while(file.hasNext() && i < NO_OF_WORDS) {
                words[i] = file.next();
                i++;
            } // end while

            long start = System.currentTimeMillis();
            insertionSort(words);
            long end = System.currentTimeMillis();
            System.out.println("Sorted Words (Insertion Sort): ");
            for(int j = 0; j < words.length; j++) {
                System.out.println(words[j]);
            } // end for

            long begin = System.currentTimeMillis();
            mergeSort(words);
            long finish = System.currentTimeMillis();
            System.out.println("Sorted Words (Merge Sort): ");
            for(int j = 0; j < words.length; j++) {
                System.out.println(words[j]);
            } // end for

            System.out.println("Running time of insertion sort: " + (end - start) + "ms");
            System.out.println("Running time of merge sort: " + (finish - begin) + "ms");

        } // end try
        catch(SecurityException securityException) {
            System.err.println("You do not have proper privilege to access the files.");
            System.exit(1);

        } // end catch
        catch(FileNotFoundException fileNotFoundException) {
            System.err.println("Error accessing file");
            System.exit(1);
        } // end catch
    } // end main
} // end class SortingAnalysis
