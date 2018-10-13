package merged;

import java.util.Iterator;

public class LookAheadIterator<T> implements Iterator<T> {
    private Iterator<T> iter;
    private T next;
    private boolean done;

    public LookAheadIterator(Iterator<T> iter) {
        this.iter = iter;
        advanceIter();
    }

    public boolean hasNext() {
        return !done;
    }

    public T next() {
        T result = next;
        advanceIter();
        return result;
    }

    public T peek() {
        return next;
    }

    private void advanceIter() {
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            done = true;
        }
    }

}
