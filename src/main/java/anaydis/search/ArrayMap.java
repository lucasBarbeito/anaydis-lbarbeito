package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K,V> implements Map<K,V>{

    private List<K> keys;
    private List<V> values;
    private Comparator comparator;

    public ArrayMap(int maxSize, Comparator comparator){
        keys = new ArrayList<K>(maxSize);
        values = new ArrayList<V>(maxSize);
        this.comparator = comparator;
    }


    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(@NotNull Object key) {
        if (size() > 0) {
            for (int i = 0; i < keys.size(); i++) {
                if (keys.get(i).equals(key)) return true;
            }
        }
        return false;
    }

    @Override
    public Object get(@NotNull Object key) {
        if (containsKey(key)){
            int position = 0;
            for (int i = 0; i < keys.size(); i++){
                if (keys.get(i).equals(key)) position = i;
            }
            return values.get(position);
        }
        return null;
    }

    @Override
    public Object put(@NotNull Object key, Object value) {
        Object returningObject = null;
        if (containsKey(key)){
            int position = 0;
            for (int i = 0; i<keys.size();i++){
                if (keys.get(i).equals(key)) position = i;
            }
            if (get(key) != null){
                returningObject.equals(values.get(position));
                values.add(position, (V) value);
            }else {
                values.add(position, (V) value);
            }
            keys.add((K) key);
            values.add((V) value);
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
