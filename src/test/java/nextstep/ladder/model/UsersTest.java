package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    private static final List<String> VALID_USERS = Arrays.asList("pobi", "honux", "crong", "jk");
    public static final Users FOUR_USERS = Users.from(VALID_USERS);

    @Test
    void fromTest() {
        // when & then
        assertThat(FOUR_USERS).isNotNull();
    }

    @Test
    void getUsersTest() {
        // when & then
        assertThat(FOUR_USERS.getUsers()).extracting(User::getName)
                .isEqualTo(VALID_USERS);
    }

    @Test
    void sizeTest() {
        // when & then
        assertThat(FOUR_USERS.size()).isEqualTo(VALID_USERS.size());
    }
}
