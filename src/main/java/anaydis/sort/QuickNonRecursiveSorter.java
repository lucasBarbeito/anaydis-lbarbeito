package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class QuickNonRecursiveSorter extends AbstractQuickSorter{

    protected QuickNonRecursiveSorter() {
        super(SorterType.QUICK_NON_RECURSIVE);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(list.size()-1);
        while (!stack.isEmpty()){
            int hi = stack.pop();
            int lo = stack.pop();
            if (hi <= lo){
                continue;
            }
            int i = partition(comparator, list, lo, hi);
            if (i - lo > hi - i){
                stack.push(lo);
                stack.push(i-1);
            }
            stack.push(i + 1);
            stack.push(hi);
            if (hi - i >= i - lo){
                stack.push(lo);
                stack.push(i -1);
            }
        }
    }
}
