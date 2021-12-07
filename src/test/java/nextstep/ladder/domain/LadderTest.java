package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @ParameterizedTest
    @DisplayName("Ladder 생성 예외 테스트")
    @NullSource
    void createExceptionLadder(Lines lines) {
        assertThatThrownBy(() -> Ladder.from(lines)).isInstanceOf(IllegalArgumentException.class);
    }
}