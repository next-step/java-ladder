package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @Test
    @DisplayName("Users 생성 테스트")
    void createUsersTest() {
        String[] usersName = {"a", "b", "c", "d", "e"};
        Users users = new Users(usersName);
        assertThat(users.getUsers().size()).isEqualTo(5);
    }

}