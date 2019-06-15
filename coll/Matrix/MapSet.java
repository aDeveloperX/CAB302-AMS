package coll.MapSet;
import java.util.*;

import java.awt.List;
import java.util.*;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V>{
    private HashMap<K, HashSet<V>> map = new HashMap<>();

    public void addValue(K k, V v){
        HashSet<V> set = new HashSet<V>();
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
        ArrayList<Set<V>> list1 = new ArrayList<>();
        for (K k : map.keySet() ) {
            list1.add(map.get(k));
        }
        Collections.sort(list1, new Comparator<Set<V>>() {
            @Override
            public int compare(Set<V> o1, Set<V> o2) {
                if(o1.size() > o2.size()){
                    return -1;
                }
                else if (o1.size() == o2.size()){
                    return 0;
                }
                else if (o1.size() < o2.size()){
                    return 1;
                }
                return 0;
            }
        });
        for (Set<V> set: list1) {
            for (V v: set ) {
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

