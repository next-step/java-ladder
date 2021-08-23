package ladder.domain.user;

import ladder.exception.EmptyUserNameException;
import ladder.exception.GreaterThenMaxUserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("User Test")
class UserTest {

    @Test
    @DisplayName("유저이름 빈값일 때 Exception 발생")
    void userNameEmptyException() {
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(EmptyUserNameException.class);
    }

    @Test
    @DisplayName("유저이름 길이가 최대값 넘을경우 Exception 발생")
    void userNameGreaterThenMaxName() {
        // given
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < User.MAX_NAME_LENGTH + 1; i++) {
            stringBuilder.append("A");
        }
        String givenName = stringBuilder.toString();

        // when
        // then
        assertThatThrownBy(() -> new User(givenName))
                .isInstanceOf(GreaterThenMaxUserNameException.class);
    }
}