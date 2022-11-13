package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("이름이 빈값이 들어가면 에러를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isblankNameException(String name) {
        assertThatThrownBy(() -> {
            new User(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름은 5자를 초과할수 없습니다.")
    @Test
    void maxLengthException() {
        assertThatThrownBy(() -> {
            new User("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}