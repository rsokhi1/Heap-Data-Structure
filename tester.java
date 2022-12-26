public class tester {
    public static void main(String[] args) {
        Heap test = new Heap(5);

        test.insert(12);
        test.insert(2);
        test.insert(5);
        test.insert(6);
        test.insert(99);
        test.insert(55);
        test.insert(3);
        test.insert(4);
        test.insert(62);
        test.insert(64);
        test.insert(65);
        test.insert(84);
        test.insert(13);
        test.insert(22);
        test.insert(61);

        test.print();

        System.out.println("The max val is "
                + test.pop_max());

        System.out.println();
        System.out.println();
        System.out.println();
        test.print();
    }
}
