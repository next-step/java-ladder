package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("사용자의 이름을 줄 수 있다.")
    @Test
    void getUserName() {
        // given
        User candy = User.of("candy");

        // then
        assertThat(candy.name()).isEqualTo("candy");
    }

    @DisplayName("이름은 5글자 이하만 가능하다. 5글자 초과 시 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenOverNameLength5() {
        // then
        assertThrows(IllegalArgumentException.class, () -> User.of("naruto"));
    }
}
