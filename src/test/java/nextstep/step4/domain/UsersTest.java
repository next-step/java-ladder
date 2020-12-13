package nextstep.step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @Test
    @DisplayName("User 별 index 부여")
    void initUsers() {
        String names = "java,game,study";
        Users users = Users.initUsers(names);

        User user1 = User.of(0, "java");
        User user2 = User.of(1, "game");
        User user3 = User.of(2, "study");
        Users manualUsers = Users.from(Arrays.asList(user1, user2, user3));

        assertThat(users).isEqualTo(manualUsers);
    }

    @Test
    @DisplayName("User가 2명 이상이 아닐 경우 예외 처리")
    void exceptUserNumbers() {
        String names = "java";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Users.initUsers(names));
    }

}