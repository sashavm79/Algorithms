public class Main {
    public static void main(String[] args) {
        int l = 6; //  6 уровней
        int trees = 20;
        Tree[] theTree = new Tree[trees];
        double N =  Math.pow(2, l)-1;
    for (int i=0; i < trees; i++){
        theTree[i] = new Tree();
        System.out.println("Дерево - " + (i+1));
        int numberLevel = 0;
        int numberOfСatsInTheTree = 0;
        while (numberLevel < 7) {
            int age = (int) (Math.random() * 200 - 100);
            Cat cat = new Cat(age , "Кот-"+ numberLevel);
            theTree[i].insert(cat);
            numberLevel = theTree[i].Level(cat.getAge());
            System.out.println(cat);
            numberOfСatsInTheTree++;
            if (numberLevel == 7)
            {
                theTree[i].delete(cat.getAge());
                numberOfСatsInTheTree--;
            }
        }
        System.out.println("Колличисто котиков в Дереве:" + numberOfСatsInTheTree);
        if ((theTree[i].isBalanced(theTree[i].root))) {
            System.out.println("Дерево сбалансировано");
        } else {
            System.out.println("Дерево не сбалансировано");
        }
        System.out.println();
    }
        int counterTrees = 0;
        for (int i = 0; i < 20; i++) {
            if (!theTree[i].isBalanced(theTree[i].root)) counterTrees++;
        }
        System.out.println(counterTrees * 5 + "% несбалансированных деревьев");
    }

}
