package ladder;

import ladder.domain.User;
import ladder.domain.Users;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {
    @Test
    void create() {
        assertThat(Users.of("a,b")).isEqualTo(new Users(Arrays.asList(new User("a"), new User("b"))));
    }
}
