package other;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LRU {

  Set<Integer> set = null;
  int capacity = 0;

  LRU(int size) {
    set = new LinkedHashSet<>(size);
    capacity = size;
  }

  public Integer get(Integer key) {
    if (set.contains(key)) {
      set.remove(key);
      set.add(key);
      return key;
    }
    return null;
  }

  public Integer put(Integer key) {
    if (set.size()<capacity) {

    } else  {
     Integer firstKey= set.iterator().next();
     set.remove(firstKey);
    }
    set.add(key);
    return key;
  }

  public void display() {

    LinkedList<Integer> ss = new LinkedList<>(set);
    Iterator<Integer> iterator = ss.descendingIterator();
    while (iterator.hasNext()) {
      System.out.print("  " + iterator.next());
    }
  }

  public static void main(String[] args) {
    LRU lru=new LRU(4);
    //Set<Integer> lru = new LinkedHashSet<>();
    lru.put(1);
    lru.put(2);
    lru.put(3);
    lru.put(4);
    lru.put(5);
    lru.put(6);
    lru.display();
//    lru.add(1);
//    lru.add(2);
//    lru.add(3);
//    lru.add(4);
//    lru.add(5);
    //System.out.print(lru);


  }
}
