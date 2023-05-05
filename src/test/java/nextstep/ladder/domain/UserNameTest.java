package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNameTest {

    @Test
    @DisplayName("입력된 사용자 이름을 반환한다.")
    void test01() {
        String expected = "1";
        UserName userName = UserName.add(expected);

        assertThat(userName.getName())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자 이름은 5자가 넘으면 예외가 발생한다.")
    void test02() {
        String name = "123456";

        assertThatThrownBy(() -> UserName.add(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("사용자 이름이 빈문자열이거나 NULL인 경우 예외가 발생한다. ")
    void test03(String name) {
        assertThatThrownBy(() -> UserName.add(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}
