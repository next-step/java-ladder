package ladder;

import ladder.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private static final String TEST_NAME = "pobi";
    private static final String ERROR_TEST_NAME = "pobing";

    @Test
    void 유저_이름_조회() {
        User user = new User(TEST_NAME);
        assertThat(user.getName()).isEqualTo(TEST_NAME);
    }

    @Test
    void 유저_이름_5글자_체크() {
        assertThatThrownBy(() -> {
            User user = new User(ERROR_TEST_NAME);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
