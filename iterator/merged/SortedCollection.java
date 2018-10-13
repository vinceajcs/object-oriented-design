package merged;

import java.util.*;

public class SortedCollection<T> extends AbstractCollection<T> {
    private Collection<T> result;

    public SortedCollection(Collection<T> c, Comparator<T> comp) {
        this.result = sort(c, comp);
    }

    public int size() {
        return result.size();
    }

    public Iterator<T> iterator() {
        return result.iterator();
    }

    private Collection<T> sort(Collection<T> c, Comparator<T> comp) {
        //int iterations = 0;
        Collection<T> c1 = new ArrayList<>();
        Collection<T> c2 = new ArrayList<>();

        T current;
        T prev = null;

        MergedCollection<T> mergedCollection = new MergedCollection<>(c1, c2, comp);

        boolean evenRun = false;
        boolean sorted = false;

        LookAheadIterator<T> iter = new LookAheadIterator<>(c.iterator());

        while (!sorted) {
            while (iter.hasNext()) {
                current = iter.next();

                if (prev == null) {
                    c1.add(current);
                    prev = current;
                } else {
                    if (!evenRun) { //add to collection 1
                        if (comp.compare(current, iter.peek()) < 0 || comp.compare(current, prev) >= 0) {
                            if (comp.compare(current, prev) < 0) {
                                c2.add(current);
                                prev = current;
                                evenRun = true;
                            } else {
                                c1.add(current);
                                prev = current;
                            }
                        } else {
                            c2.add(current);
                            prev = current;
                            evenRun = true;
                        }
                    } else { //add to collection 2
                        if (comp.compare(current, iter.peek()) < 0 || comp.compare(current, prev) >= 0) {
                            if (comp.compare(current, prev) < 0) {
                                c1.add(current);
                                prev = current;
                                evenRun = false;
                            } else {
                                c2.add(current);
                                prev = current;
                            }
                        } else {
                            c1.add(current);
                            prev = current;
                            evenRun = false;
                        }
                    }
                }
            }

            if (c2.isEmpty()) sorted = true; //if c2 is empty this means c1 should contain one run of sorted elements

            mergedCollection = new MergedCollection<>(c1, c2, comp);
            iter = new LookAheadIterator<>(mergedCollection.iterator());

            c1 = new ArrayList<>();
            c2 = new ArrayList<>();

            prev = null;
            evenRun = false;
        }

        return mergedCollection;
    }

//    private boolean sorted(Collection<T> c, Comparator<T> comp) {
//        T current;
//
//        LookAheadIterator<T> iter = new LookAheadIterator<>(c.iterator());
//        while (iter.hasNext()) {
//            current = iter.next();
//            if (comp.compare(current, iter.peek()) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }

}
