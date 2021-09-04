package newladder;

import newladder.model.User;
import newladder.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    private static final String[] TEST_NAME_LIST = {"pobi", "crong", "test"};
    private static final String[] ERROR_TEST_NAME_LIST = {"pobi", "pobi", "crong", "test"};

    Users users;

    @BeforeEach
    void setting() {
        users = new Users(TEST_NAME_LIST);
    }

    @Test
    void 유저_이름_포함_체크() {
        assertThatThrownBy(() -> {
            users = new Users(ERROR_TEST_NAME_LIST);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_정보_체크() {
        for (User user : users.usersInfo()) {
            assertThat(Arrays.asList(TEST_NAME_LIST))
                    .contains(user.nameInfo());
        }
    }
}
