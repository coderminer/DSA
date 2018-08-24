/**
 * BinarySearch
 */
public class BinarySearch {

    public int binarySearch(int[] arrs, int target) {
        int len = arrs.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arrs[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int target = 610;
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arrs, target));
    }
}