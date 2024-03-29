package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.User.MAXIMUM_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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

    @DisplayName("이름의 길이 제한을 검증한다. 제한글자 초과 시 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenOverNameLengthLimit() {
        // given
        String overLimitName = "a".repeat(MAXIMUM_NAME_LENGTH + 1);

        // then
        assertThatIllegalArgumentException()
                        .isThrownBy(() -> User.of(overLimitName));
    }
}
