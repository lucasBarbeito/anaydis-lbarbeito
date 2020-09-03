package anaydis.sort;

import anaydis.sort.DataSetGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntegerDataSetGenerator implements DataSetGenerator<Integer> {

    public IntegerDataSetGenerator(){

    }
    @NotNull
    @Override
    public List<Integer> createAscending(int length) {
        List<Integer> returningList = new ArrayList<>();

        for(int i = 0; i < length; i++){
            returningList.add(i);
        }
        return returningList;
    }

    @NotNull
    @Override
    public List<Integer> createDescending(int length) {
        List<Integer> returningList = new ArrayList<>();

        for(int i = length; i > 0; i--){
            returningList.add(i);
        }
        return returningList;
    }

    @NotNull
    @Override
    public List<Integer> createRandom(int length) {
        List<Integer> returningList = new ArrayList<>();

        for(int i = 0; i < length; i++){
            returningList.add((int) (Math.random() * 1000000));
        }
        return returningList;
    }

    @NotNull
    @Override
    public Comparator<Integer> getComparator() {

        return Comparator.naturalOrder();
    }
}
