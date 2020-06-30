public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set (int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    // homework

    // Метод добавления новый элемент в массив
    public void insert(int index, int value){
        if (size >= arr.length) {
            increaseCapacity();
        }
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        for (int i = size ; i > index ; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size++;
        isSorted = false;
    }

    // Метода удаления заданного элемента
    public void deleteValue(int value){
        int number = find(value);
        if (number == -1)
            throw new ArrayIndexOutOfBoundsException("Такого элемента отсутствует!");

        for (int i = number ; i < size-1 ; i++) {
            arr[i] = arr[i+1];
        }
        deleteLast();
    }

    // Метод удаления по заданному индексу
    public void deleteIndex(int index){
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Элемента с таким индексом отсутствует!");

        for (int i = index ; i < size-1 ; i++) {
            arr[i] = arr[i+1];
        }
        deleteLast();
    }

    // Метод удаления всех элементов массива
    public void deleteAll(){
        size = 0;
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
                count++;
            }
        }
        isSorted = true;
        System.out.println("Количество операций sortBubble:" + count);
        // Количество операций - 90 (n^2), т.к. во втором цыкле: size - 1
    }
    // улучшенная пузырьковая сортировка
    public void sortBubbleBest() {
        int count = 0;
        for (int i = 0; i < (size / 2); i++) {
            for (int j = 0; j < size - 2; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
                if (arr[size - j - 1] < arr[size - j - 2]) {
                    swap(size - j - 1, size - j - 2);
                }
                count++;
            }
        }
        isSorted = true;
        System.out.println("Количество операций sortBubbleBest:" + count);
    }
        // Количество операций - 40 (n^2)/2, т.к. цыкле: size/2


    public void sortSelect() {
        int count = 0;
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++){
                if (arr[rem] < arr[cMin])
                    cMin = rem;
                count++;
            }
            swap(flag, cMin);
        }
        isSorted = true;
        System.out.println("Количество операций sortSelect:" + count);
    }
    // Количество операций - 45 (n^2)/2, т.к. во втором цыкле: flag + 1

    public void sortInsert() {
        int count = 0;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
                count++;
            }
            arr[in] = temp;
        }
        isSorted = true;
        System.out.println("Количество операций sortInsert:" + count);
        // Количество операций - 19 (n^2)/2, т.к. зависит от расположения элемкнтов в массиве
    }
    // Метод сортировка подсчетом

    public void sortCount() {
        int count = 0;
        int[] countArr = new int[size];
        int l = 1;
        for (int h = 0; h < size; h++){
            countArr[h] = 0;
            count++;
        }
        for (int j = 0; j < size; j++) {
            countArr[arr[j]] = countArr[arr[j]] + 1;
            count++;
        }
        for (int k = 0; k < size; k++) {
            arr[k] = l;
            if (countArr[l] > 0) countArr[l] = countArr[l] -1;
            if (countArr[l] == 0) l++;
            count++;
        }
        isSorted = true;
        System.out.println("Количество операций sortInsert:" + count);
        // Количество операций - 30 (n*3)
    }
}
