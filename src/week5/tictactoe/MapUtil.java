package week5.tictactoe;

import java.util.*;

public class MapUtil {
    //@requires map.keySet().size() >= 0;
    //@requires  map.size() >= 0;
    //@ensures \result ? map.keySet().size() <= map.size() : map.keySet().size() > map.size()
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        return map.keySet().size() <= map.size();
    }


    //@requires map.keySet().size() >= 0;
    //@requires  map.size() >= 0;
    //@ensures \result ? map.keySet().size() <= map.size() : map.size() > map.keySet().size()
    public static <K, V>
    boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (K key : map.keySet()) {
            range.remove(map.get(key));
        }
        return range.size() == 0;
    }

    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Set<K> allKeys = new HashSet<K>();
        for (K key : map.keySet())
            allKeys.add(key);
        Map<V, Set<K>> inverseMap = new HashMap<V, Set<K>>();
        List<V> allValues = new ArrayList<V>();
        for (K key : allKeys) {
            allValues.add(map.get(key));
        }
        for (V vally : allValues) {
            inverseMap.put(vally, allKeys);
        }
        return inverseMap;
    }

    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> res = new HashMap<V, K>();
        for (K key : map.keySet()) {
            V val = map.get(key);
            res.put(val, key);
        }
        return res;
    }

    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        //values van f in keys van g
        boolean compat = true;
        for (V val : f.values()) {
            if (!g.containsKey(val)) {
                compat = false;
            }
        }
        return compat;
    }

    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> cmpsd = new HashMap<K, W>();
        for (K key : f.keySet()) {
            V gkey = f.get(key);
            W gval = g.get(gkey);
            cmpsd.put(key, gval);
        }
        return cmpsd;
    }
}
