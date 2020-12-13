package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    @DisplayName("유저 생성 테스트")
    void createUser() {
        String name = "java";
        User user = User.of(name);
        assertThat(user.toString()).isEqualTo(name);
    }

}