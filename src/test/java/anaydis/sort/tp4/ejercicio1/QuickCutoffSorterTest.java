package anaydis.sort.tp4.ejercicio1;

import anaydis.sort.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuickCutoffSorterTest {

    private final DataSetGenerator<Integer> generator = new IntegerDataSetGenerator();
    private final QuickCutoffSorter sorter = (QuickCutoffSorter) new SorterProviderImpl().getSorterForType(SorterType.QUICK_CUT);

    @Test
    public void testGenerator(){
        List<Integer> integerList = generator.createRandom(8);
        Assert.assertEquals(8, integerList.size());
    }

    @Test
    public void testAscending(){
        List<Integer> integerList = generator.createAscending(8);
        List<Integer> integerList1 = new ArrayList<>(integerList);
        sorter.sort(generator.getComparator().reversed(), integerList1);
        sorter.sort(generator.getComparator(), integerList1);
        Assert.assertEquals(integerList, integerList1);
    }

    @Test
    public void testDescending(){
        List<Integer> integerList = generator.createDescending(8);
        List<Integer> integerList1 = new ArrayList<>(integerList);
        sorter.sort(generator.getComparator(), integerList1);
        sorter.sort(generator.getComparator().reversed(), integerList1);
        Assert.assertEquals(integerList, integerList1);
    }
}
