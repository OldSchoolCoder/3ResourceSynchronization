import org.junit.Test;

public class StorageTest {

    @Test
    public void testUser() {
        UserStore stoge = new UserStore();
        stoge.add(new User(1, 100));
        stoge.add(new User(2, 200));
        stoge.transfer(1, 2, 50);
    }
}
