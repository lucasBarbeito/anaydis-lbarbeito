package anaydis.sort;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPractice03 {

    @Test
    public void FullNameComparatorTest(){
        List<FullName> fullNames = new ArrayList<>(8);
        InsertionSorter insertionSorter = new InsertionSorter();

        fullNames.add(new FullName("Pedro", "Colunga"));
        fullNames.add(new FullName("Lucas", "Luppani"));
        fullNames.add(new FullName("Alvaro", "Gaita"));
        fullNames.add(new FullName("Khalil", "Stessens"));
        fullNames.add(new FullName("Pedro", "Luppani"));
        fullNames.add(new FullName("Lucas", "Gaita"));
        fullNames.add(new FullName("Alvaro", "Stessens"));
        fullNames.add(new FullName("Khalil", "Colunga"));

        Collections.shuffle(fullNames);

        insertionSorter.sort(FullNameComparator.lastNameComparator(),fullNames);
        insertionSorter.sort(FullNameComparator.firstNameComparator(),fullNames);

        for (FullName fullName : fullNames) {
            System.out.println(fullName.getLastname() + ", " + fullName.getFirstname());
        }

    }


}
