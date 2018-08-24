/**
 * LinearSearch
 */
public class LinearSearch {

    public int linearSearch(int[] arrs,int target){
        int len = arrs.length;
        for(int i = 0;i < len;i++){
            if(arrs[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 54;
        int[] arrs = {2,3,4,5,6,8,1,9,10,23,13,34,43,12,14,15,16};
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.linearSearch(arrs,target));
        
    }
    
}