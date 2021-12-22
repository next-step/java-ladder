package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    private static final List<User> VALID_USERS = Arrays.asList(new User("pobi"), new User("honux"), new User("crong"), new User("jk"));

    @Test
    void createTest() {
        // when & then
        assertThat(Users.from(VALID_USERS)).isNotNull();
    }

    @Test
    void getUsersTest() {
        // given
        Users users = Users.from(VALID_USERS);
        // when & then
        assertThat(users.getUsers()).isEqualTo(VALID_USERS);
    }
}
