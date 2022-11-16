package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @Test
    @DisplayName("Users 생성 테스트")
    void createUsers() {
        final List<User> userList = List.of(UserTest.USER_TEST1, UserTest.USER_TEST2);
        Users users = new Users(userList);
        assertThat(users.getUsers()).containsAll(userList);
    }

    @Test
    @DisplayName("Users 사이즈 테스트")
    void getUserSize() {
        final List<User> userList = List.of(UserTest.USER_TEST1, UserTest.USER_TEST2);
        Users users = new Users(userList);
        assertThat(users.getUsers()).hasSize(userList.size());
    }
}