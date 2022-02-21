public class main {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array);
        array.delete(2);
        System.out.println(array);
    }
}