import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private DynamicList<T> list = new DynamicList<T>();

    public synchronized void add(T value) {
        list.add(value);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }

    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }

    private DynamicList<T> copy(DynamicList<T> list) {
        DynamicList<T> copyOfList = new DynamicList<T>();
        for (T element : list) {
            copyOfList.add(element);
        }
        return copyOfList;
    }
}
