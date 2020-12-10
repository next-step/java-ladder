package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("사용자 이름 유효성 검사 테스트")
    @ParameterizedTest
    @ValueSource(
            strings = {
                    "",
                    "aaaaaa"
            }
    )
    public void userNameValidCheckTest(String name) {
        assertThatThrownBy(
                () -> {
                    User user = new User(name);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 이름을 null 으로 줬을때 예외발생 테스트")
    @Test
    public void userNameIfNullExceptionTest() {
        assertThatThrownBy(
                () -> {
                    User user = new User(null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
