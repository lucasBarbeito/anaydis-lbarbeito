package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class BinaryTreeMapTest {
    ArrayMap<Integer, Integer> arrayMap = new ArrayMap<Integer, Integer>(Comparator.naturalOrder());

    @Test
    public void testArrayMap(){
        arrayMap.put(1, 11);
        arrayMap.put(2, 12);
        arrayMap.put(3, 13);
        arrayMap.put(4, 14);
        arrayMap.put(5, 15);
        arrayMap.put(6, 16);
        arrayMap.put(7, 17);
        arrayMap.put(8, 18);
        arrayMap.put(9, 19);
        arrayMap.put(10, 20);

        Assert.assertTrue(arrayMap.containsKey(7));
        Assert.assertEquals(10, arrayMap.size());
        Assert.assertEquals(11, (int) arrayMap.get(1));
        Assert.assertEquals(12, (int) arrayMap.get(2));
        Assert.assertEquals(13, (int) arrayMap.get(3));
        Assert.assertEquals(14, (int) arrayMap.get(4));
        Assert.assertEquals(15, (int) arrayMap.get(5));
        Assert.assertEquals(16, (int) arrayMap.get(6));
        Assert.assertEquals(17, (int) arrayMap.get(7));
        Assert.assertEquals(18, (int) arrayMap.get(8));
        Assert.assertEquals(19, (int) arrayMap.get(9));
        Assert.assertEquals(20, (int) arrayMap.get(10));


        arrayMap.clear();
        Assert.assertTrue(arrayMap.isEmpty());
    }
}
