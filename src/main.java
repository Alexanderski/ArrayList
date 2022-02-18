public class main {
    public static void main(String[] args) {
        MyArrayList<String> array = new MyArrayList<>();
        array.add("a");
        array.add("azzzzzzz");
        array.add("ds");
        array.add("gcxzc");
        array.add("dasdx");
        array.add("bb");
        array.add("asdbhhh");
        System.out.println(array.isEmpty());
        System.out.println(array.index("gcxzc"));

        System.out.println(array);
    }
}