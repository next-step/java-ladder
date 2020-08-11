package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @DisplayName("해당 유저가 있을 경우 잘 반환 되는지 확인")
    @Test
    public void getUser() {
        Users users = new Users();
        assertThat(users.getUser("crong")).isEqualTo(new User("crong", 35));
    }


    @DisplayName("해당 유저가 없을 경우 기본 유저 정보가 잘 반환되는지 확인")
    @Test
    public void getDefaultUser() {
        Users users = new Users();
        assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
    }
}
