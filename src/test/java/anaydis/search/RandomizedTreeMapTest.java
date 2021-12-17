package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomizedTreeMapTest {

    RandomizedTreeMap<Integer, Integer> randomizedTreeMap = new RandomizedTreeMap<>(Integer::compareTo);

    @Test
    public void testRandomizedTreeMap(){
        randomizedTreeMap.put(1, 11);
        randomizedTreeMap.put(2, 12);
        randomizedTreeMap.put(2, 13);
        randomizedTreeMap.put(3, 19);
        randomizedTreeMap.put(4, 14);
        randomizedTreeMap.put(5, 15);
        randomizedTreeMap.put(5, 6);
        randomizedTreeMap.put(6, 16);
        randomizedTreeMap.put(7, 17);
        randomizedTreeMap.put(8, 18);
        randomizedTreeMap.put(9, 19);
        randomizedTreeMap.put(9, 2);
        randomizedTreeMap.put(10, 20);

        Assert.assertTrue(randomizedTreeMap.containsKey(1));
        Assert.assertTrue(randomizedTreeMap.containsKey(3));
        Assert.assertTrue(randomizedTreeMap.containsKey(4));
        Assert.assertTrue(randomizedTreeMap.containsKey(5));
        Assert.assertTrue(randomizedTreeMap.containsKey(8));
        Assert.assertTrue(randomizedTreeMap.containsKey(10));
        Assert.assertTrue(randomizedTreeMap.containsKey(7));
        Assert.assertTrue(randomizedTreeMap.containsKey(2));
        Assert.assertTrue(randomizedTreeMap.containsKey(6));
        Assert.assertTrue(randomizedTreeMap.containsKey(9));
        Assert.assertNotNull(randomizedTreeMap.get(10));
        Assert.assertNotNull(randomizedTreeMap.get(5));
        Assert.assertEquals(2, (int) randomizedTreeMap.get(9));
        Assert.assertEquals(6, (int) randomizedTreeMap.get(5));
        Assert.assertEquals(10, randomizedTreeMap.size());
        List<Integer> list = new ArrayList<>();
        randomizedTreeMap.keys().forEachRemaining(list::add);
        Assert.assertEquals(10, list.size());
        randomizedTreeMap.clear();
        Assert.assertTrue(randomizedTreeMap.isEmpty());
    }
}
