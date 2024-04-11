package ladder;

import ladder.domain.Name;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    void 이름_생성(String input) {
        Name name = new Name(input);
        assertThat(name).isEqualTo(new Name(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "ab c", " abc"})
    void 이름_생성_빈값_포함(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(input))
                .withMessage("참가자의 이름은 공백을 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void 이름_생성_길이_초과(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(input))
                .withMessage("참가자의 이름은 1자 이상 5자 이하여야 합니다.");
    }
}
