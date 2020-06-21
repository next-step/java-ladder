package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"ab", "abc"})
    @DisplayName("사람은 이름으로 생성할 수 있다")
    void user_success(String name) {
        Name userName = Name.of(name);
        assertThat(User.of(userName)).isNotNull();
    }

    @ParameterizedTest(name = "input = {0}")
    @NullSource
    @DisplayName("사람은 이름 객체가 null인 경우 생성할 수 없다.")
    void validate_name_is_null(Name name) {
        assertThatThrownBy(() -> User.of(name))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("User 객체를 생성할 수 없습니다.");
    }
}