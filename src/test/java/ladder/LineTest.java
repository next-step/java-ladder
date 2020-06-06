package ladder;

import ladder.domain.ErrorMessages;
import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("Line 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7})
    public void makeLineObject(int playerCounts) {
        assertThatCode(() -> {
            new Line(playerCounts);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Line 객체 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    public void throwExceptionOnMakingLineObject(int playerCounts) {
        assertThatThrownBy(() -> {
            new Line(playerCounts);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_PLAYER_COUNTS);
    }
}
