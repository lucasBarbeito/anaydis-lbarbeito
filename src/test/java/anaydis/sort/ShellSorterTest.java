package anaydis.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShellSorterTest {

    private final DataSetGenerator<Integer> generator = new IntegerDataSetGenerator();
    private final int[] seq = {1, 8, 23, 77, 281, 1073, 4193, 16577};
    private final ShellSorter sorter = (ShellSorter) new SorterProviderImpl().getSorterForType(SorterType.SHELL);

    @Test
    public void testGenerator(){
        List<Integer> integerList = generator.createRandom(8);
        Assert.assertEquals(8, integerList.size());
    }

    @Test
    public void testAscending(){
        List<Integer> integerList = generator.createAscending(8);
        List<Integer> integerList1 = new ArrayList<>(integerList);
        sorter.sort(generator.getComparator().reversed(), integerList1, seq);
        sorter.sort(generator.getComparator(), integerList1, seq);
        Assert.assertEquals(integerList, integerList1);
    }

    @Test
    public void testDescending(){
        List<Integer> integerList = generator.createDescending(8);
        List<Integer> integerList1 = new ArrayList<>(integerList);
        sorter.sort(generator.getComparator(), integerList1, seq);
        sorter.sort(generator.getComparator().reversed(), integerList1, seq);
        Assert.assertEquals(integerList, integerList1);
    }
}
