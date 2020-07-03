package hw3;


public class Mirror {
    //  ДЗ Задание № 1
    public static char[] mirror(String input){
        int size = input.length();
        if (size == 0) {
            input = "ytpmE";
            size = 5;
        }
        Stack stack = new Stack(size);
        char[] ch = new char[size];
        for (int i = 0; i < size; i++){
            stack.push(input.charAt(i));
        }
        for (int i = 0; i < size; i++){
            ch[i] = (char) stack.pop();
        }
        return ch;
    }
}