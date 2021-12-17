package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

public class TSTTrieMapTest {

    TSTMap<String> tstTrieMap = new TSTMap<>();

    @Test
    public void rWayTrieMapTest(){
        tstTrieMap.put("M", "C");
        tstTrieMap.put("F", "R");
        tstTrieMap.put("I", "M");
        Assert.assertTrue(tstTrieMap.containsKey("M"));
        Assert.assertTrue(tstTrieMap.containsKey("F"));
        Assert.assertTrue(tstTrieMap.containsKey("I"));
        Assert.assertEquals(3, tstTrieMap.size());
        Assert.assertEquals("C", tstTrieMap.get("M"));
        Assert.assertEquals("R", tstTrieMap.get("F"));
        Assert.assertEquals("M", tstTrieMap.get("I"));
        Assert.assertNotNull(tstTrieMap.get("F"));
        Assert.assertFalse(tstTrieMap.isEmpty());
        Assert.assertTrue(tstTrieMap.keys().hasNext());
        tstTrieMap.clear();
        Assert.assertTrue(tstTrieMap.isEmpty());
    }
}
