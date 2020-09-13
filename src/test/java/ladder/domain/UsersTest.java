package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {
    @DisplayName("Users 생성 테스트")
    @Test
    void createUsers_Test() {
        Users users = Users.userNameList("pobi,honux,crong,jk");
        assertThat(users.getUsers()).containsExactly(
                User.of("pobi"),
                User.of("honux"),
                User.of("crong"),
                User.of("jk")
        );
    }

    @DisplayName("Users Size 테스트")
    @Test
    void users_Size_Test() {
        Users users = Users.userNameList("pobi,honux,crong,jk");
        assertThat(users.getUsers().size()).isEqualTo(4);
    }
}