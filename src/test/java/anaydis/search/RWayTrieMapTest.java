package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

public class RWayTrieMapTest {

    RWayTrieMap<String> rWayTrieMap = new RWayTrieMap<>();

    @Test
    public void rWayTrieMapTest(){
        rWayTrieMap.put("M", "C");
        rWayTrieMap.put("F", "R");
        rWayTrieMap.put("I", "M");
        Assert.assertTrue(rWayTrieMap.containsKey("M"));
        Assert.assertTrue(rWayTrieMap.containsKey("F"));
        Assert.assertTrue(rWayTrieMap.containsKey("I"));
        Assert.assertEquals(3, rWayTrieMap.size());
        Assert.assertEquals("C", rWayTrieMap.get("M"));
        Assert.assertEquals("R", rWayTrieMap.get("F"));
        Assert.assertEquals("M", rWayTrieMap.get("I"));
        Assert.assertNull(rWayTrieMap.get("W"));
        Assert.assertNotNull(rWayTrieMap.get("F"));
        Assert.assertFalse(rWayTrieMap.isEmpty());
        Assert.assertTrue(rWayTrieMap.keys().hasNext());
        rWayTrieMap.clear();
        Assert.assertTrue(rWayTrieMap.isEmpty());
    }
}
