package anaydis.sort;

import java.util.Comparator;

public class FullNameComparator {

    public static Comparator<FullName> lastNameComparator(){
        return Comparator.comparing(FullName::getLastname);
    }

    public static Comparator<FullName> firstNameComparator(){
        return Comparator.comparing(FullName::getLastname);
    }


}
