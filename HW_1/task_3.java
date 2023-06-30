package HW_1;

import java.util.Arrays;

public class task_3 {
    public static int[] arrayDiff(int[] reduced, int[] deduced){
        int[] difference = null;
        if (reduced.length != deduced.length){
            throw new RuntimeException("длины массивов не равны");
        }
        else {
            difference = new int[reduced.length];
            for (int i = 0; i < difference.length; i++){
                difference[i] = reduced[i] - deduced[i];
            }
        }
        return difference;
    }
    public static void main(String[] args) {
        int[] arr1 = {2,1,5,4,3};
        int[] arr2 = {3,8,4,1,2};
        System.out.println(Arrays.toString(arrayDiff(arr1,arr2)));
    }
}
