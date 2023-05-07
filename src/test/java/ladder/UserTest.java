package ladder;

import ladder.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserTest {
    @DisplayName("참여자 이름이 null 또는 빈문자열인 경우 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyName(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User(input))
                .withMessageMatching("유효하지 않은 이름입니다.");
    }

    @DisplayName("참여자 이름이 5자를 초과할 경우 예외가 발생한다")
    @Test
    void carCreateFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User("UserNameFailTest"))
                .withMessageMatching("이름은 최대 5글자까지 허용합니다.");
    }
}
