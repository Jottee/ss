package week5;

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
        Map inverseMap = new HashMap<V, Set<K>;
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

        return false;
    }

    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
    }
}
