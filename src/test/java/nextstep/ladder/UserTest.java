package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    @DisplayName("성공 - User 객체가 정상 생성 된다.")
    void initUserTest() {
        User user = new User("홍길동");
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("홍길동");
    }
}
