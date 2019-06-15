import java.util.*;
package coll.MapSet;
import java.awt.List;
import java.util.*;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V>{
    private HashMap<K, HashSet<V>> map;
    HashSet<V> set = new HashSet<V>();

    public MapSet() {
        map = new HashMap<K, HashSet<V>>();
    }

    public void addValue(K k, V v){
        if (map.containsKey(k)){
            map.get(k).add(v);
        }else if(map.containsKey(k) == false){
            set.add(v);
            map.put(k, set);
        }
    }

    @Override
    public Iterator<V> iterator() {
        ArrayList<V> list = new ArrayList<V>();
        for (HashSet<V> set: map.values()) {
            for(V v: set){
                list.add(v);
            }
        }
        return list.iterator();
    }

    @Override
    public Set<Entry<K, HashSet<V>>> entrySet() {
        return map.entrySet();
    }
}

