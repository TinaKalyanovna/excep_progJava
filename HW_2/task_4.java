package HW_2;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//Пользователю должно показаться сообщение, что пустые строки вводить нельзя.


import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите что нибудь");
            String str = in.nextLine();
            if(str.isEmpty()) throw new Exception("Нельзя вводить пустые строки");
            System.out.println("Вы ввели");
            System.out.println(str);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
