package HW_2;

// Дан следующий код, исправьте его там, где требуется
//
//public static void main(String[] args) throws Exception {
//    try {
//        int a = 90;
//        int b = 3;
//        System.out.println(a / b);
//        printSum(23, 234);
//        int[] abc = { 1, 2 };
//        abc[3] = 9;
//    } catch (Throwable ex) {
//        System.out.println("Что-то пошло не так...");
//    } catch (NullPointerException ex) {
//        System.out.println("Указатель не может указывать на null!");
//    } catch (IndexOutOfBoundsException ex) {
//        System.out.println("Массив выходит за пределы своего размера!");
//    }
//}
//public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//    System.out.println(a + b);
//}

public class task_3 {
    public static void main(String[] args){
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234); // можно передать переменную a, b. Условия задачи не понятны
//             int[] abc = { 1, 2 }; массив нигде не используется можно удалить
//             abc[3] = 9; выдаст ошибку IndexOutOfBoundsException Условия задачи не ясны, незнаю что сним делать
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!" + ex);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null! " + ex);
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так..." + ex);
        }
    }
    public static void printSum(Integer a, Integer b){
        System.out.println(a + b);
    }
}
