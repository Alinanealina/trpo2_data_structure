import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception
    {
        list a = new list(1);
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(3);
        a.print();

        a.del();
        a.print();

        a.add_ind(0, 3);
        a.print();

        a.del_ind(2);
        a.print();

        a.sort();
        a.print();
    }
}

class elem {
    int a;
    elem next;
    elem(int a)
    {
        this.a = a;
        next = null;
    }
}
interface listint
{
    int toDo(int a);
}
class list {
    private elem head;
    list()
    {
        head = null;
    }
    list(int a)
    {
        add(a);
    }
    void print()
    {
        for (elem p = head; p != null; p = p.next)
            System.out.print(p.a + " ");
        System.out.println();
    }
    int length()
    {
        int i;
        elem p;
        for (p = head, i = 0; p != null; p = p.next, i++);
        return i;
    }
    ArrayList<Integer> get_asAL()
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (elem p = head; p != null; p = p.next)
            al.add(p.a);
        return al;
    }

    void add(int a)
    {
        if (head == null)
            head = new elem(a);
        else
        {
            elem p;
            for (p = head; p.next != null; p = p.next);
            p.next = new elem(a);
        }
    }
    void del() throws Exception
    {
        elem p;
        if (head == null)
            throw new Exception("Список пустой");
        if (length() == 1)
            head = null;
        else
        {
            for (p = head; p.next.next != null; p = p.next);
            p.next = null;
        }
    }

    void add_ind(int a, int ind) throws Exception
    {
        int i;
        elem p, q;
        if ((ind < 0) || (ind >= length()))
            throw new Exception("Индекс выходит за границы списка");
        if (ind == 0)
        {
            q = head;
            head = new elem(a);
            head.next = q;
        }
        else
        {
            for (p = head, i = 0; i < ind - 1; p = p.next, i++);
            q = p.next;
            p.next = new elem(a);
            p.next.next = q;
        }
    }
    void del_ind(int ind) throws Exception
    {
        int i;
        elem p;
        if ((ind < 0) || (ind >= length()))
            throw new Exception("Индекс выходит за границы списка");
        if (ind == 0)
            head = head.next;
        else
        {
            for (p = head, i = 0; i < ind - 1; p = p.next, i++);
            p.next = p.next.next;
        }
    }

    void forEach(listint a)
    {
        todo(a, head);
    }
    private void todo(listint a, elem p)
    {
        if (p == null)
            return;
        p.a = a.toDo(p.a);
        todo(a, p.next);
    }

    list sort()
    {
        int[] buf = new int[length()];
        elem p;
        int i;
        for (p = head, i = 0; p != null; p = p.next, i++)
            buf[i] = p.a;
        int[] res = mergeSort(buf, new int[length()], 0, length());
        list sort = new list(res[0]);
        for (i = 1; i < res.length; i++)
            sort.add(res[i]);
        head = sort.head;
        return sort;
    }
    private int[] mergeSort(int[] buf, int[] buf2, int L, int R)
    {
        if (L >= R - 1)
            return buf;
        int m = L + (R - L) / 2, i = L, j = m, k = L;
        int[] sort = mergeSort(buf, buf2, L, m), sort2 = mergeSort(buf, buf2, m, R), res;
        if (sort == buf)
            res = buf2;
        else
            res = buf;
        for (; (i < m) && (j < R); k++)
        {
            if (sort[i] < sort2[j])
                res[k] = sort[i++];
            else
                res[k] = sort[j++];
        }
        for (; i < m; i++, k++)
            res[k] = sort[i];
        for (; j < R; j++, k++)
            res[k] = sort2[j];
        return res;
    }
}