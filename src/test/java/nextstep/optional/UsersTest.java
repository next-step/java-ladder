package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Optional 실습 - Users 클래스 테스트")
public class UsersTest {

    @Test
    @DisplayName("Users 리스트에 존재하는 유저를 받아온다.")
    void getUser() {
        Users users = new Users();
        assertThat(users.getUser("crong")).isEqualTo(new User("crong", 35));
    }


    @Test
    @DisplayName("Users 리스트에 존재하지 않으면 DEFAULT_USERS가 반환된다.")
    void getDefaultUser() {
        Users users = new Users();
        assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
    }
}
