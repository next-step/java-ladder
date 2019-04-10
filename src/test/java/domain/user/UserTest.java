package domain.user;

import org.junit.Test;

public class UserTest {

    @Test(expected = IllegalArgumentException.class)
    public void name_length_validation() {
        String name = "123456";
        User user = new User(name);
    }
}
