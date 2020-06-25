public class Algorithm {
    public static void main(String[] args) {

        int a = 4;
        int b = 3;

        int[] arr = {5, 3, 1, 2, 4};

        // 11 Возведение в степень
        System.out.println(pow(b, a));

        // Методе бинарного возведения в степень
        System.out.println(paw2(b, a));

        // 12 Поиск минимального элемента в массиве
        System.out.println(min(arr));

        //13 Нахождение среднего арифметического массива
        System.out.println(arithmeticMean(arr));
    }

    /*
    Простое возведение в степень. Сложность линейная О(n), так как  колличество операцый растет пропорционально показателю степени
    (содержит один цикл for).
     */

    public static int pow(int x, int y){
        int result = 1;
        for (int i = 0; i < y; i++){
            result = result * x;
        }
        return result;

    }

    /*
    Методе бинарного возведения в степень с использование четности. Сложность бинарная О(log n), так как происходит изменение (уменьшение) степени в 2 раза при каждом проходе рекурсивной функцией.
     */


    public static int paw2(int x, int y) {
            if (y == 0) {
            return 1;
            }
            if (y % 2 == 0) {
                return paw2(x * x, y / 2);
            } else {
                return x * paw2( x ,y-1);
            }
    }

    /*
    Поиск минимального элемента в массиве. Сложность линейная О(n), так как содержит один цикл for и он проходится полностью.
     */
    public static int min(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    /*
    Поиск среднего арифметического в массиве. Сложность линейная О(n), так как содержит один цикл for, а постоянные множетили не учитываются.
     */

    public static double arithmeticMean(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        double am = sum / arr.length;
        return am;
    }
}