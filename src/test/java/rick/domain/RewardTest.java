package rick.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardTest {

    @Test
    @DisplayName("이름 일치 테스트")
    void name() {
        String input = "name";

        assertThat(new Reward(input).getName())
            .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefgh"})
    @DisplayName("긴 보상명 테스트")
    void tooLongNameLength(final String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Reward(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, empty 문자열")
    void nullAndEmptyName(final String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Reward(name));
    }
}
