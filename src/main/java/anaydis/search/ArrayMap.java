package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K,V> implements Map<K,V>{

    private List<K> keys;
    private List<V> values;
    private Comparator<K> comparator;

    public ArrayMap(Comparator comparator){
        keys = new ArrayList<>();
        values = new ArrayList<>();
        this.comparator = comparator;
    }


    @Override
    public int size() {
        return keys.size() ;
    }

    private int indexOf(K key){
        if (isEmpty()) return -1;
        if (find(key,0,size() - 1) > 0)
            return find(key,0,size()-1);
        return -1;
    }
    private int find(K key, int low, int high){
        if (low > high) return -(low +1);
         int midValue = (low + high)/2;
         int comparation = comparator.compare(key,keys.get(midValue));
         if (comparation == 0){
             return midValue;
         }else if (comparation > 0){
             return find(key, midValue + 1, high);
         }else {
             return find(key, low , midValue-1);
         }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(@NotNull K key) {
        if (size() > 0) {
            for (int i = 0; i < keys.size(); i++) {
                if (keys.get(i).equals(key)) return true;
            }
        }
        return false;
    }

    @Override
    public V get(@NotNull K key) {
        if (indexOf(key) != -1){
            return values.get(indexOf(key));
        }
        return null;
    }

    @Override
    public V put(@NotNull K key, V value) {
        V returningObject = null;
        int index = find(key,0,size()-1);
        if (index < 0 ){
            index = - (index) - 1;
            values.add(index,value);
            keys.add(index,key);
        }else {
            returningObject = values.get(index);
            values.add(index,value);
        }
        return returningObject;
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Iterator keys() {
        return keys.iterator();
    }
}
