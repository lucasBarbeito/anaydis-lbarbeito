package anaydis.sort.tp4.ejercicio2;

import anaydis.sort.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickMedianOfThreeSorterTest {

    private final DataSetGenerator<Integer> generator = new IntegerDataSetGenerator();
    private final QuickMedianOfThreeSorter sorter = (QuickMedianOfThreeSorter) new SorterProviderImpl().getSorterForType(SorterType.QUICK_MED_OF_THREE);

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
        assertThat(integerList).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(integerList1);
        //Assert.assertEquals(integerList, integerList1);
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
