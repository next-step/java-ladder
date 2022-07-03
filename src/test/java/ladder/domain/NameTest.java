package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {
    @DisplayName("입력한 사용자의 이름이 null 일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void create_inputBlank(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayerName(names))
                .withMessageContaining("이름은 빈 값을 입력 할 수 없습니다.");
    }

    @DisplayName("입력한 사용자의 이름은 5글자 이하만 사용 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = "user12345, user2")
    void create_invalidUserName(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayerName(names))
                .withMessageContaining("이름은 1 ~ 5 글자만 허용됩니다.");
    }
}
