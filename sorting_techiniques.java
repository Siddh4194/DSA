//selection sort
import java.io.*;
import java.util.Arrays;
    
public class text {
    //print array
    static void printarray(int[] arr){
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{7,8,3,1,2};
        // iterate through the array
        for(int i=0;i<arr.length;i++){
            int smallest=i; //initialized smallest
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest]>arr[j]){//checking for the smallest no in the array to know its position
                    smallest=j;
                }
            }
            //swapping the position of elements
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
        }
        printarray(arr);
    }
}
//insertion sort
import java.io.*;
import java.util.Arrays;
    
public class text {
    //print array
    static void printarray(int[] arr){
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{7,8,3,1,2};
        // iterate through the array
        for(int i=1;i<arr.length;i++){
            int current=arr[i]; //element from unsortedpart
            int j=i-1; //sorted part
            while(j>=0 && current>arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=current;
        }
        //print the whole array
        printarray(arr);
    }
}
//quick sort
import java.io.*;
import java.util.Arrays;
    
public class text {
    //print array
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot)
            {
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //pivote element is swapped with reamaining element and pivote element is placed at the position of it self
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;
    }
    static void quicksort(int[] arr,int low,int high){
        if(low<high){//first check whether it is low and high are not same
            int pindx = partition(arr,low,high);
            quicksort(arr, low, pindx-1);
            quicksort(arr, pindx+1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{7,8,3,1,2};
        quicksort(arr,0,arr.length-1);
        //print
        for(int i:arr){
            System.out.print(i);
        }
    }
}

//merge sort
 import java.io.*;
import java.util.Arrays;
    
public class text {
    //print array
    public static void conquer(int[] arr,int si,int mid,int ei){
        int[] merger=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int x=0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]){
                merger[x++]=arr[idx1++];
            }else{
                merger[x++]=arr[idx2++];
            }
        }
        //if remaining elements are there then store it
        while(idx1<=mid){
            merger[x++]=arr[idx1++];
        }
        while(idx2<=ei){
            merger[x++]=arr[idx2++];
        }
        //all element from the merger to the main arr
        for(int i=0,j=si;i<merger.length;i++,j++){
            arr[j]=merger[i];
        }
    }
    static void divide(int[] arr,int si,int ei){
        if(si>=ei) return;
        int mid=si+(ei-si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        //passed for merging the array
        conquer(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        int[] arr=new int[]{7,8,3,1,2};
        divide(arr,0,arr.length-1);
        //print
        for(int i:arr){
            System.out.print(i);
        }
    }
}
