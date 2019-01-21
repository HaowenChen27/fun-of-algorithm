package sort;

import java.util.Arrays;

/**
 * 分治法 复杂问题简单化
 *
 */
public class QuickSort {

    public static void quickSort(int[] arr,int l,int r){
        //确定基数 一般以第一个数作为第一个基数
        if(l>=r){
            return;
        }
        int temp;
        int v = arr[l];
        int i = l;
        int j = r;
        while(i<j){
            //找到比基数小的 arr[j]
            while (i<j&&arr[j]>=v){
                j--;
            }
            //找到比基数大的 arr[i]
            while(i<j&&arr[i]<=v){
                i++;
            }
            //比基数大的和比基数小的换位置
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        //i和j相碰时基数和当前值位置互换
        temp = arr[i];
        arr[i] = v;
        arr[l] = temp;
        //以当前i为分界点继续排列
        quickSort(arr,l,i);
        quickSort(arr,i+1,r);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,7,2,4,1,3,8,9,5,10,6,7,3,11,2};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
