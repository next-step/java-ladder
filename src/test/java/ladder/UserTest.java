package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {

    @Test
    @DisplayName("user 생성 테스트")
    public void createUser() {
        // given
        String name = "jk";

        // when
        User user = new User(name);

        // then
        assertThat(user).isEqualTo(new User("jk"));
    }

    @Test
    @DisplayName("user 생성 실패 테스트")
    public void createUser_fail() {
        // given
        String name = "stevie";

        // when
        assertThatIllegalArgumentException().isThrownBy(() -> new User(name));
    }

}