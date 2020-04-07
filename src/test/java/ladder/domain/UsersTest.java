package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @Test
    @DisplayName(",를 구분자로 유저 생성")
    void create() {
        Users users = Users.of("yohan,hmin,abc");

        assertThat(users.getUsers()).containsExactly(User.of("yohan"), User.of("hmin"), User.of("abc"));
    }
}
