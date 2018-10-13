package merged;

import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collection;

public class MergedCollection<T> extends AbstractCollection<T> {
    private Comparator<T> comp;
    private Collection<T> c1;
    private Collection<T> c2;

    private int size;

    public MergedCollection(Collection<T> c1, Collection<T> c2, Comparator<T> comp) {
        this.comp = comp;
        this.c1 = c1;
        this.c2 = c2;
        this.size = c1.size() + c2.size();
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new MergedIterator<>(c1.iterator(), c2.iterator(), comp);
    }
}
