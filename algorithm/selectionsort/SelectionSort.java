
/**
 * SelectionSort
 */
public class SelectionSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void selectionSort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if(SelectionSort.less(arr[j], arr[min])){
                    min = j;
                }
            }
            SelectionSort.swap(arr,i,min);
        }
    }

    public static void main(String[] args) {
        Comparable[] arrs = { 5, 7, 4, 8, 3, 9, 2, 0, 1, 6 };

        SelectionSort.selectionSort(arrs);

        for(Comparable arr : arrs){
            System.out.println(arr);
        }
    }
}