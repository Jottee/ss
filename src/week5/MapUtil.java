package week5;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        
        return null;
    }

    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
    }

    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
    }

    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
    }
}
