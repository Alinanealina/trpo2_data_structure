import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class listTest {
    @Test
    public void test_add() throws Exception
    {
        list a = new list(1);
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(3);
        ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 4, 3));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());

        a.add_ind(0, 3);
        e = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 0, 4, 3));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());
        
        a.add_ind(3, 0);
        e = new ArrayList<Integer>(Arrays.asList(3, 1, 5, 2, 0, 4, 3));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());
    }

    @Test
    public void test_del() throws Exception
    {
        list a = new list(1);
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(3);
        a.del();
        ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 4));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());

        a.del_ind(0);
        e = new ArrayList<Integer>(Arrays.asList(5, 2, 4));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());

        a.del_ind(1);
        e = new ArrayList<Integer>(Arrays.asList(5, 4));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());
    }

    @Test
    public void test_sort() throws Exception
    {
        list a = new list(1);
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(3);
        a.sort();
        ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());
    }

    @Test
    public void test_foreach()
    {
        list a = new list(1);
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(3);
        a.forEach(new listint() {
            @Override
            public int toDo(int a)
            {
                return ++a;
            }
        });
        ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(2, 6, 3, 5, 4));
        assertArrayEquals(e.toArray(), a.get_asAL().toArray());
    }
}
