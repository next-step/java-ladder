package ladder;

import ladder.domain.ErrorMessages;
import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("Line 객체 생성시 player 수에 비례한 List<Point> 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    public void testPointsList(int playerCounts) {
        Line line = new Line(playerCounts);

        assertThat(line.getLineSize())
                .isEqualTo((playerCounts - 1) * 5);
    }
}
