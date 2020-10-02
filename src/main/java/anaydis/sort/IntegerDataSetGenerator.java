package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
        Random rand = new Random();

        for(int i = 0; i < length; i++){
            returningList.add(rand.nextInt(1000000) );
        }
        return returningList;
    }

    @NotNull
    @Override
    public Comparator<Integer> getComparator() {

        return Comparator.naturalOrder();
    }


}
