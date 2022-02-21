import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @org.junit.jupiter.api.Test
    void sort() {
        //given
        MyArrayList<Integer> ints = new MyArrayList<>();
        ints.add(3);
        ints.add(4);
        ints.add(2);
        ints.add(1);
        //when
        ints.sort(Integer::compareTo);
        //then
        assertEquals(1,ints.get(0));
        assertEquals(2,ints.get(1));
        assertEquals(3,ints.get(2));
        assertEquals(4,ints.get(3));
    }

    @org.junit.jupiter.api.Test
    void shouldShowIfListIsEmpty() {
        //given
        MyArrayList<String> strings = new MyArrayList<>();
        //when
        strings.add("hello world");
        //then
        assertFalse(strings.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void add() {
        //given
        MyArrayList<Integer> ints = new MyArrayList<>();
        //when
        ints.add(123);
        //then
        assertEquals(123, ints.get(0));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        //given
        MyArrayList<String> names = new MyArrayList<>();
        //when
        names.add(0,"Alex");
        names.add(1,"Andrew");
        names.add(0,"Anton");
        //then
        assertEquals("Alex",names.get(1));
        assertEquals("Andrew",names.get(2));
        assertEquals("Anton",names.get(0));

    }

    @org.junit.jupiter.api.Test
    void size() {
        //given
        MyArrayList<Integer> ints = new MyArrayList<>();
        //when
        ints.add(1);
        ints.add(2);
        ints.add(3);
        //then
        assertEquals(3, ints.size());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        //given
        MyArrayList<Integer> ints = new MyArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        assertEquals(3,ints.size(),"Before removal");
        //when
        ints.delete(2);
        //then
        assertEquals(2,ints.size(),"After removal");

    }

    @org.junit.jupiter.api.Test
    void index() {
        //given
        MyArrayList<Integer> ints = new MyArrayList<>();
        ints.add(0,24);
        ints.add(1,33);
        ints.add(2,44);
        //when
        ints.index(33);
        //then
        assertEquals(1,ints.index(33));

    }

    @org.junit.jupiter.api.Test
    void get() {
        //given
        MyArrayList<String> getTest = new MyArrayList<>();
        getTest.add("Alex");
        //when
        getTest.get(0);
        //then
        assertEquals("Alex",getTest.get(0));

    }

    @org.junit.jupiter.api.Test
    void set() {
        //given
        MyArrayList<Integer> ints = new MyArrayList<>();
        ints.add(0,1);
        ints.add(1,2);
        ints.add(2,3);
        //when
        ints.set(1,33);
        //then
        assertEquals(33,ints.get(1));
    }
}