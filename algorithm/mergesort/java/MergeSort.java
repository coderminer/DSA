/**
 * MergeSort
 */
public class MergeSort {

    public void sort(int arr[]){
        int []tmp = new int[arr.length];
        sort(arr,0,arr.length - 1,tmp);
    }

    private void sort(int arr[],int left,int right,int tmp[]){
        if(left < right){
            int mid = (left + right) >> 1;
            System.out.println("sort mid "+mid);
            sort(arr,left,mid,tmp);
            sort(arr,mid + 1,right,tmp);
            merge(arr,left,mid,right,tmp);
        }
    }

    private void merge(int arr[],int left,int mid,int right,int tmp[]){
        System.out.println("merge");
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]){
                tmp[t++] = arr[i++];
            }else{
                tmp[t++] = arr[j++];
            }
        }

        while(i <= mid){
            tmp[t++] = arr[i++];
        }

        while (j <= right) {
            tmp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right){
            arr[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1};
        MergeSort ms = new MergeSort();

        ms.sort(arr);
        for(int item : arr){
            System.out.print(item+" ");
        }
    }

}