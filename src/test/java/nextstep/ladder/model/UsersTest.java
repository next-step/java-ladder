package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {
    private static final List<User> VALID_USERS = Arrays.asList(
            new User(new UserName("pobi")),
            new User(new UserName("honux")),
            new User(new UserName("crong")),
            new User(new UserName("jk"))
    );
    public static final Users USERS = Users.from(VALID_USERS);

    @Test
    void fromTest() {
        // when & then
        assertThat(USERS).isNotNull();
    }

    @Test
    void getUsersTest() {
        // when & then
        assertThat(USERS.getUsers()).isEqualTo(VALID_USERS);
    }

    @Test
    void sizeTest() {
        // when & then
        assertThat(USERS.size()).isEqualTo(VALID_USERS.size());
    }
}
