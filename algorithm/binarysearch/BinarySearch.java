/**
 * BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrs = {3,4,2,5,6,9,7,8,1,0};
        int index = BinarySearch.binarySearch(arrs, 8);
        System.out.println("index: "+index);
    }

    public static int binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            System.out.println("mid: "+mid);
            int midVal = arr[mid];
            if(midVal < key){
                low = mid + 1;
            }else if(midVal > key){
                high = mid - 1;
            }else{
                return mid;
            }
        }

        return -(low + 1);
    }
    
}