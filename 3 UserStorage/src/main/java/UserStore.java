import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class UserStore {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();

    public synchronized void transfer(int fromId, int toId, int amount) {
        int oldAmount;
        oldAmount = users.get(fromId).getAmount();
        users.get(fromId).setAmount(oldAmount - amount);
        oldAmount = users.get(toId).getAmount();
        users.get(toId).setAmount(oldAmount + amount);
    }

    public synchronized boolean add(User user) {
        users.put(id.incrementAndGet(), user);
        return users.containsValue(user);
    }

    public synchronized boolean update(User user) {
        users.put(user.getId(), user);
        return users.containsValue(user);
    }

    public synchronized boolean delete(User user) {
        return users.remove(user.getId(), user);
    }
}
