package step4.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("User 객체 생성 테스트")
    void createUserTest() {

        // given
        Name name = Name.of("name");

        // when
        User result = User.of(name);

        // then
        assertThat(result).isEqualTo(User.of(name));
    }

}