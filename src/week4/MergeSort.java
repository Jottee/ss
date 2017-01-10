package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>>
    void mergesort(List<E> list) {
        List<E> res = new ArrayList<E>();
        if (list.size() > 1) {
            int mid = list.size() / 2;
            List<E> fst;
            List<E> snd;
            fst = list.subList(0, mid);
            snd = list.subList(mid, list.size());
            int f = 0;
            int s = 0;
            mergesort(fst);
            mergesort(snd);
            while (f < fst.size() && s < snd.size()) {
                if (fst.get(f).compareTo(snd.get(s)) < 0) {
                    res.add(fst.get(f));
                    f++;
                } else {
                    res.add(snd.get(s));
                    s++;
                }
            }
            if (f < fst.size()) {
                res.addAll(fst.subList(f, fst.size()));
            } else if (s < snd.size()) {
                res.addAll(snd.subList(s, snd.size()));
            }

            Collections.copy(list, res);
        }
    }
}

