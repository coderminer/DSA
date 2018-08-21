import java.util.Arrays;

/**
 * BubbleSort
 */
public class BubbleSort {
    public void sort(int[] arrs) {
        int len = arrs.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arrs[i] < arrs[j]) {
                    int tmp = arrs[j];
                    arrs[j] = arrs[i];
                    arrs[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrs = { 3, 1, 23, 45, 4, 5, 13, 25, 56, 24 };
        BubbleSort bs = new BubbleSort();
        bs.sort(arrs);
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }
}