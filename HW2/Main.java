import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array a0 = new Array(1, -2, -3, -4, 5);
        Array a1 = new Array(1, -2, -3, -4, 5);
        Array a2 = new Array(1, -2, -3, -4, 5);
        Array a3 = new Array(1, -2, -3, -4, 5);
        Array a4 = new Array(1, -2, -3, -4, 5, 6, -7, -8, 9, 10);
        Array a41 = new Array(1, -2, -3, -4, 5, 6, -7, -8, 9, 10);
        Array a5 = new Array(-1, 2, 3, 4, -5, -6, 7, 8, -9, -10);
        Array a6 = new Array(1, -2, -3, -4, 5, 6, -7, -8, 9, 10);
        Array a7 = new Array(1, 4, 3, 1, 2, 3, 3, 2, 4, 1);
        a0.insert(1, 2);
        System.out.println(a0);
        System.out.println("Длина массива: " + a0.length());
        a1.deleteValue(-3);
        System.out.println(a1);
        System.out.println("Длина массива: " + a1.length());
        a2.deleteIndex(4);
        System.out.println(a2);
        System.out.println("Длина массива: " + a2.length());
        a3.deleteAll();
        System.out.println(a3);
        System.out.println("Длина массива: " + a3.length());
        a4.sortBubble();
        System.out.println(a4);
        a41.sortBubbleBest();
        System.out.println(a41);
        a5.sortSelect();
        System.out.println(a5);
        a6.sortInsert();
        System.out.println(a6);
        a7.sortCount();
        System.out.println(a7);
    }
}
