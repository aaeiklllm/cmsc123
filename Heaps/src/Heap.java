
public class Heap {
    //This method gets the parent of index i
    private static int getParent(int i) {
        return (int) Math.floor(i/2);
    }

    //This method gets the left child of index i
    private static int getLeft(int i) {
        return (2*i)+1;
    }

    //This method gets the right child of index i
    private static int getRight(int i) {
        return (2*i)+2;
    }

    //This method does the maxHeapify operation on ith element of the heap
    public static void maxHeapify(int arr[], int heapSize, int i) {
        int largest = i;

        if (getLeft(i) < heapSize && arr[getLeft(i)] > arr[largest])
            largest = getLeft(i);

        if (getRight(i) < heapSize && arr[getRight(i)] > arr[largest])
            largest = getRight(i);

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, heapSize, largest);
        }
    }

    //This method builds a max-heap from the arr[]
    public static void buildMaxHeap(int arr[]){
        int heapSize = arr.length;
        for (int i = getParent(heapSize)-1; i >= 0; i--){
            maxHeapify(arr, heapSize, i);
        }
    }

    //This method sorts the array using heap sort
    public static void heapSort(int arr[]){
        buildMaxHeap(arr);

        for (int i = arr.length-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        int[] list = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapSort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
            //1 2 3 4 7 8 9 10 14 16
        }
        System.out.println();

        int[] list1 = {13, 77, 24, 82, 1, 8, 10, 23, 99, 67};

        heapSort(list1);

        for (int i = 0; i < list1.length; i++) {
            System.out.print(list1[i] + " ");
            //1 8 10 13 23 24 67 77 82 99 
        }
    }
}
