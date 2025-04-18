package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.support.TestConstants.USERS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest {
    @DisplayName("Users 객체를 생성한다.")
    @Test
    public void createUsersTest() {
        Users users = new Users(USERS);
        assertEquals(USERS.size(), users.count());
    }

    @DisplayName("User의 index를 가져온다.")
    @Test
    public void getUserIndexTest() {
        Users users = new Users(USERS);
        int index = users.getIndex(new User(USERS.get(0)));
        assertEquals(0, index);
    }
}
