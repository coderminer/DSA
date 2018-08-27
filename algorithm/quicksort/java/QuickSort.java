/**
 * QuickSort
 */
public class QuickSort {

    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    private void quickSort(int arr[], int left, int right) {
        int i, j, t, tmp;
        if (left > right)
            return;
        tmp = arr[left];
        i = left;
        j = right;
        while (i != j) {
            while (arr[j] >= tmp && i < j) {
                j--;
            }
            while (arr[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = tmp;

        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = tmp;
        System.out.println("partition");
        return i + 1;
    }

    private void quickSort2(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort2(arr, left, p - 1);
            quickSort2(arr, p + 1, right);
        }
    }

    private void quickSort3(int arr[], int left, int right) {
        while (left < right) {
            int p = partition(arr, left, right);
            quickSort3(arr, left, p - 1);
            left = p + 1;
        }
    }

    private void quickSort4(int arr[], int left, int right) {
        while (left < right) {
            int p = partition(arr, left, right);
            if (p - left < right - p) {
                quickSort4(arr, left, p - 1);
                left = p + 1;
            } else {
                quickSort4(arr, p + 1, right);
                right = p - 1;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
        QuickSort qs = new QuickSort();
        qs.quickSort4(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}