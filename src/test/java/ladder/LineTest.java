package ladder;

import ladder.domain.ErrorMessages;
import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @DisplayName("Line 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15})
    public void makeLineObject(int playerCounts) {
        assertThatCode(() -> {
            Line.drawLine(playerCounts);
        }).doesNotThrowAnyException();
    }

    @DisplayName("PlayerCounts가 1 미만인 경우 객체 생성 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void throwExceptionOnMakingLineObject(int playerCounts) {
        assertThatThrownBy(() -> {
            Line.drawLine(playerCounts);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_PLAYER_COUNTS);
    }

    @DisplayName("Line 객체를 통해 그린 Line의 길이는 playerCounts - 1과 동일함")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15})
    public void lineSizeTest(int playerCounts) {
        Line line = Line.drawLine(playerCounts);

        List<Boolean> pointPositions = line.getPointPositions();

        assertThat(pointPositions.size()).isEqualTo(playerCounts - 1);
    }
}
