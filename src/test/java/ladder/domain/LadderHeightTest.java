package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {
    @Test
    @DisplayName("사다리 높이가 생성된다.")
    void createLadderHeightTest() {
        assertThat(new LadderHeight("5")).isEqualTo(new LadderHeight(5));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("사다리 높이 유효성 검사한다. 유효하지 않으면 에러 발생한다.")
    void validateLadderHeightTest(String input) {
        assertThatThrownBy(() -> new LadderHeight(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
