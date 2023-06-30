package HW_1;

import java.util.Arrays;

public class task_4 {
    public static int[] arrayQuotient(int[] divisible, int[] divisor){

        if (divisible == null || divisor == null){
            throw new RuntimeException("в качестве аргумента получен null");
        }

        if (divisible.length != divisor.length){
            throw new RuntimeException("длины массивов не равны");
        }
        int[] quotient = new int[divisible.length];
        for (int i = 0; i < quotient.length; i++){
            if (divisor[i] == 0){
                throw new RuntimeException("Нельзя делить на ноль");
            }
            quotient[i] = divisible[i] / divisor[i];
        }
        return quotient;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,0};
        System.out.println(Arrays.toString(arrayQuotient(arr1,arr2)));
    }
}
