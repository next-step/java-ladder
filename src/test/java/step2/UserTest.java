package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.User;
import step2.domain.Users;

public class UserTest {

    private Users users;

    @BeforeEach
    void setUp() {
        this.users = new Users("pobi,crong,jk");
    }

    @Test
    void findUser() {
        User searchUser = users.find("pobi");
        assertEquals("pobi", searchUser.name().value());
    }

    @Test
    void userNotFound() {
        assertThrows(IllegalArgumentException.class, () -> users.find("doik"));
    }
}
