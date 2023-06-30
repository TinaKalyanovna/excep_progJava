package HW_1;

import java.util.Arrays;

public class task_1 {
    /*
    Метод ишет максимальное значение 3 соседних элементов, 
    последний и первый элемент считается соседним
    Возможны следующие ошибки
    1) если шаг будет больше длины массива получим ошибку:
    ArrayIndexBoundsException
    */
    public static int method1(int[] array, int step) {

        System.out.println(Arrays.toString(array));
        if (array == null){
            throw new RuntimeException("в качестве аргумента получен null");
        }
        int tempVal, maxVal = 0;
        for (int i = 0; i < step; i++){
            maxVal += array[i];
        }
        tempVal = maxVal;

        for (int i = 0; i < array.length-1; i++){
            int j = (i + step) % array.length;
            tempVal = tempVal - array[i] + array[j];
            if (tempVal>maxVal){
                maxVal = tempVal;
            }
        }
        return maxVal;
    }
    /*
    Метод принимает в качестве аргументов два целочисленных 
    массива, и возвращает новый массив,
    каждый элемент которого равен частному элементов двух 
    входящих массивов в той же ячейке.
    Возможны следующие ошибки
    1) если делитель 0 получим ошибку:
    ArithmeticException
    */
    public static int[] method2(int[] divisible, int[] divisor){
        if (divisible == null || divisor == null){
            throw new RuntimeException("в качестве аргумента получен null");
        }

        if (divisible.length != divisor.length){
            throw new RuntimeException("длины массивов не равны");
        }
        System.out.println("делимое "+Arrays.toString(divisible));
        System.out.println("делитель "+Arrays.toString(divisible));
        int[] quotient = new int[divisible.length];
        for (int i = 0; i < quotient.length; i++) {
            quotient[i] = divisible[i] / divisor[i];
        }
        return quotient;
    }

    /*
    Метод принимает в качестве аргументов строку, 
    и сравнивает сумму первых х цифр с последними х цифрами
    где х количесво цифр. если сумма первых х цифр 
    равна последним х цифрам возврашает строку с сообщением Повезло
    иначе Невезет
    Возможны следующие ошибки
    1) если в строке передаваемый в аргумент содержится 
    любой другой символ кроме целого числа
    NumberFormatException
    */
    public static String method3(String ticket, int count){
        if (ticket == null){
            return "Аргумент равне null";
        }
        int firstNumberSum = 0, lastNumberSum = 0;
        if (ticket.length()>=count*2){
            int firstNumber = Integer.parseInt((ticket).substring(0,count));
            int lastNumber = Integer.parseInt((ticket).substring((ticket.length()-count)));
            for (int i = 0; i < count; i++){
                firstNumberSum += firstNumber % 10;
                lastNumberSum += lastNumber % 10;
                firstNumber /= 10;
                lastNumber /= 10;
            }
        }
        else
            return "Номер короткий";
        if (firstNumberSum == lastNumberSum){
            return "Повезло";
        }
        else {
            return "Невезет";
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,5,1,2,3};
        int[] arr2 = {3,8,4,1,2};
        String str = "134008";
        System.out.println("наибольшая сумма "+method1(arr1,3));
        System.out.println();
        System.out.println("частное "+Arrays.toString(method2(arr1,arr2)));
        System.out.println();
        System.out.println("сумма первых цифр суммой последних цифр "+method3(str,3));

    }
}
