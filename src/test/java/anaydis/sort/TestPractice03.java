package anaydis.sort;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestPractice03 {

    @Test
    public void FullNameComparatorTest(){
        List<FullName> fullNames = new ArrayList<>(8);
        SelectionSorter selectionSorter = new SelectionSorter();

        fullNames.add(new FullName("Pedro", "Colunga"));
        fullNames.add(new FullName("Lucas", "Luppani"));
        fullNames.add(new FullName("Alvaro", "Gaita"));
        fullNames.add(new FullName("Khalil", "Stessens"));
        fullNames.add(new FullName("Pedro", "Luppani"));
        fullNames.add(new FullName("Lucas", "Gaita"));
        fullNames.add(new FullName("Alvaro", "Stessens"));
        fullNames.add(new FullName("Khalil", "Colunga"));

        Collections.shuffle(fullNames);

        selectionSorter.sort(FullNameComparator.firstNameComparator(),fullNames);
        selectionSorter.sort(FullNameComparator.lastNameComparator(),fullNames);

        for (FullName fullName : fullNames) {
            System.out.println(fullName.getLastName() + ", " + fullName.getFirstName());
        }

    }

}
