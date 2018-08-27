/**
 * JumpSearch
 */
public class JumpSearch {

    public int jumpSearch(int[] arrs, int target) {
        int len = arrs.length;
        int step = (int) Math.floor(Math.sqrt(len));
        int prev = 0;

        while (arrs[Math.min(step, len) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(len));
            if (prev >= len) {
                return -1;
            }
        }

        while (arrs[prev] < target) {
            prev++;
            if (prev == Math.min(step, target)) {
                return -1;
            }
        }

        if (arrs[prev] == target) {
            return prev;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrs = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
        int target = 55;
        JumpSearch js = new JumpSearch();
        System.out.println(js.jumpSearch(arrs, target));
    }

}