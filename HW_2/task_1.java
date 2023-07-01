package HW_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_1 {
    //    public static float method2(){
//        Scanner in = new Scanner(System.in);
//        float digit;
//        while (true){
//            System.out.println("Введите дробное число");
//            if (in.hasNextFloat()){
//                digit = Float.parseFloat(scanner.nextLine());
//                break;
//            }
//            else {
//                System.out.println("неправильный ввод");
//                in.nextLine();
//            }
//        }
//        return digit;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float digit;
        while (true){
            try {
                System.out.println("Введите дробное число : ");
                digit = in.nextFloat();

            }catch (InputMismatchException e){
                System.out.println("неправильный ввод");
                in.nextLine();
                continue;
            }
            break;
        }
        System.out.println("Вы ввели");
        System.out.println(digit);
    }
}
