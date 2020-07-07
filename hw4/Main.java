package hw4;

public class Main {
    public static void main(String[] args)  {
        DualList rl = new DualList();
        rl.pushHead(new Cat(2, "cat1"));
        rl.push(new Cat(3, "cat2"));
        rl.push(new Cat(4, "cat3"));
        rl.push(new Cat(5, "cat4"));
        rl.pushHead(new Cat(6, "cat5"));
        System.out.println(rl);
        System.out.println(rl.pop());
        System.out.println(rl);

        Iterator iterator = new Iterator(rl);
        iterator.reset();
        iterator.insertAfter(new Cat(7, "cat6"));


        System.out.println(rl);

    }
    //reset();
    //next();
    //getCurrent();
    //hasNext();
    //atEnd();
    //insertAfter();
    //*insertBefore();
    //deleteCurrent();

}