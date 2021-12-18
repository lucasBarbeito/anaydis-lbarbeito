package anaydis.immutable;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    private List<Integer> list = List.nil();

    @Test
    public void testNode(){
        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(0, length(list));
        list = List.cons(4, List.nil());
        Assert.assertEquals(4, list.head().longValue());
        list = List.cons(4, List.cons(3, List.nil()));
        Assert.assertEquals(3, list.tail().head().longValue());
        list = List.cons(4, List.cons(3, List.cons(2, List.nil())));
        Assert.assertEquals(2, list.tail().tail().head().longValue());
        list = List.cons(4, List.cons(3, List.cons(2, List.cons(1, List.nil()))));
        Assert.assertEquals(1, list.tail().tail().tail().head().longValue());
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(4, length(list));
    }

    @Test
    public void testReversedNode(){
        Assert.assertTrue(list.isEmpty());
        list = List.cons(4, List.cons(3, List.cons(2, List.cons(1, List.nil()))));
        List<Integer> reversed = list.reverse();
        Assert.assertEquals(1, reversed.head().longValue());
        Assert.assertEquals(2, reversed.tail().head().longValue());
        Assert.assertEquals(3, reversed.tail().tail().head().longValue());
        Assert.assertEquals(4, reversed.tail().tail().tail().head().longValue());
    }

    public int length(List<Integer> list){
        if (list.isEmpty()){
            return 0;
        }else return 1 + length(list.tail());
    }
}
