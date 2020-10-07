import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserStore {

    public synchronized void transfer(int fromId, int toId, int amount) {
    }

    public synchronized boolean add(User user) {
        return false;
    }

    public synchronized boolean update(User user) {
        return false;
    }

    public synchronized boolean delete(User user) {
        return false;
    }
}
