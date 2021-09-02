package ladder.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @Test
    @DisplayName("user 이름을 받아 user를 생성할 수 있다.")
    void userCreateTest() {

        // given
        String input = "name";

        // when
        User user = new User(input);

        // then
        assertThat(user).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", "namename", "inputinput"})
    @DisplayName("5글자 넘는 이름으로 User를 생성하면 Exception이 반환되어야 한다")
    void userCreateFailByLargeNameTest(String input) {

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new User(input))
            .withMessageMatching("사람의 이름은 최대 5글자까지만 입력가능하다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사람의 이름이 제공되지 않을 때 Exception이 반환되어야 한다.")
    void userCreateFailByEmptyNameTest(String input) {

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new User(input))
            .withMessageMatching("사람의 이름은 반드시 제공되어야 한다.");
    }

}