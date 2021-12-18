package anaydis.immutable;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeTest {

    BinaryTree<String, Integer> binaryTree = new BinaryTree<>(String::compareTo);

    @Test
    public void binaryTreeTest(){
        List<String> list = new ArrayList<>();
        list.add("maia");
        list.add("ale");
        list.add("ivan");
        list.add("franco");
        Assert.assertTrue(binaryTree.isEmpty());
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("maia", 3);
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("ale", 4);
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("pedro", 4);
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("rodrigo", 8);
        Assert.assertTrue(binaryTree.containsKey("maia"));
        Assert.assertEquals(4, binaryTree.get("ale").longValue());
        Assert.assertEquals(4, binaryTree.size());
        List<String> list1 = new ArrayList<>();
        Objects.requireNonNull(binaryTree.keys()).forEachRemaining(list1::add);
        Assert.assertEquals(4, list.size());
        Assert.assertTrue(Objects.requireNonNull(binaryTree.keys()).hasNext());
        Assert.assertEquals("ale", Objects.requireNonNull(binaryTree.keys()).next());
    }
}
