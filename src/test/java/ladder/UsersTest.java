package ladder;

import ladder.model.User;
import ladder.model.Users;
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
    void 유저리스트_갯수_체크() {
        assertThat(users.getUserSize()).isEqualTo(TEST_NAME_LIST.length);
    }

    @Test
    void 유저_이름_포함_체크() {
        assertThatThrownBy(() -> {
            users = new Users(ERROR_TEST_NAME_LIST);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_정보_체크() {
        for (User user : users.getParticipants()) {
            assertThat(Arrays.asList(TEST_NAME_LIST)
                    .stream()
                    .filter(name -> name.equals(user.getName()))
                    .count()).isOne();
        }
    }
}
