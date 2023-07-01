package HW_2;

// Если необходимо, исправьте данный код
//   try {
//        int d = 0;
//        double catchedRes1 = intArray[8] / d;
//        System.out.println("catchedRes1 = " + catchedRes1);
//   } catch (ArithmeticException e) {
//        System.out.println("Catching exception: " + e);
//   }


public class task_2 {
    public static void dz(int[] intArray) {
        try {

            int d = 1;
            double catchedRes1 = (double) intArray[8] / d;
            if (Double.isInfinite(catchedRes1)) throw new ArithmeticException("infinity");
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за пределы индекса " + e);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,9,11,23,56};
        dz(arr);
    }
}
