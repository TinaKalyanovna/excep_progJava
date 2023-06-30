

/* 
public static int sum2d(String[][]arr){
    int sum = 0;
    for (int i = 0; i < arr.length; i++){
        for (int j = 0; j < 5; j++){
            int val = Integer.parseInt(arr[i][j]);
            sum += val;
        }
    }
    return sum;
}

1) логическая ошибка (не будет суммировать числа в строках(второе измерение) длинее 5 элементов)
2) если какая-то строка (второе измерение массива) меньше 5 получим ошибку (ArrayIndexBoundsException)
3) если какойто элемент будет содержать не число или не целое число получим ошибку (NumberFormatException)
4) если передать в качестве аргумента String[][] str = null или String[][] str = new String[x][] где х какоето число
        получим ошибку (NullPointerException)
*/