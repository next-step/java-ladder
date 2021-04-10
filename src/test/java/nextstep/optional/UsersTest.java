package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @DisplayName("Users에서 이름으로 검색시 알맞는 객체를 반환하는지 테스트")
    @Test
    public void getUser() {
        Users users = new Users();
        assertThat(users.getUser("crong")).isEqualTo(new User("crong", 35));
    }

    @DisplayName("Users에서 존재하지 않는 이름으로 검색시 디폴트 값을 반환하는지 테스트")
    @Test
    public void getDefaultUser() {
        Users users = new Users();
        assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
    }
}
