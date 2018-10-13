package merged;

import java.util.*;

public class MergedIterator<T> implements Iterator<T> {
   private LookAheadIterator<T> i1, i2;
   private Comparator<T> comp;
   private T prev = null;

   public MergedIterator(Iterator<T> iter1, Iterator<T> iter2, Comparator<T> comp) {
      i1 = new LookAheadIterator<T>(iter1);
      i2 = new LookAheadIterator<T>(iter2);
      this.comp = comp;
   }

   public boolean hasNext() {
      return i1.hasNext() || i2.hasNext();
   }

   public T next() {
      T result;

      if (!i1.hasNext()) {
         result = i2.next();
      } else if (!i2.hasNext()) {
         result = i1.next();
      } else {
         if (prev == null) {
            //first iteration, no prev element yet - pick smaller of i1 and i2
            result = comp.compare(i1.peek(), i2.peek()) <= 0 ? i1.next() : i2.next();
            prev = result;
         } else {
            //check if elements from both iterators are less than previous element
            if (comp.compare(i1.peek(), prev) < 0 && comp.compare(i2.peek(), prev) < 0) {
               result = comp.compare(i1.peek(), i2.peek()) < 0 ? i1.next() : i2.next();
               prev = result;
            } else {
               if (comp.compare(i1.peek(), i2.peek()) < 0) {
                  result = comp.compare(i1.peek(), prev) > 0 ? i1.next() : i2.next();
                  prev = result;
               } else {
                  result = comp.compare(i2.peek(), prev) > 0 ? i2.next() : i1.next();
                  prev = result;
               }
            }
         }
      }

      return result;
   }
}
