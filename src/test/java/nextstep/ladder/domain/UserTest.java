package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    public static final User USER_TEST1 = new User("test1");
    public static final User USER_TEST2 = new User("test2");

    @Test
    @DisplayName("유저 생성 테스트")
    void createUser() {
        final String name = "hong";
        User user = new User(name);
        assertThat(user).isEqualTo(new User(name));
    }

    @Test
    @DisplayName("유저 이름 테스트")
    void getName() {
        final String name = "hong";
        User user = new User(name);
        assertThat(user.getName()).isEqualTo(name);
    }
}