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
        int index = find(key, 0, size() - 1);
        return index >= 0 ? index : -1;
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
       return find(key,0,size()-1) >= 0;
    }

    @Override
    public V get(@NotNull K key) {
        int index = indexOf(key);
        if (index != -1){
            return values.get(index);
        }
        return null;
    }

    @Override
    public V put(@NotNull K key, V value) {
        V returningObject = null;
        int index = find(key,0,size()-1);
        if (index < 0 ){
            index = - (index) - 1;
            keys.add(index,key);
            values.add(index,value);
        }else {
            returningObject = values.set(index,value);
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
