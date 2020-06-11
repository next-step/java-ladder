/*
package ladder;

import ladder.domain.LadderBuildingException;
import ladder.domain.Line;
import ladder.domain.RandomDrawingLineStrategy;
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
            Line.drawLine(playerCounts, new RandomDrawingLineStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("PlayerCounts가 1 미만인 경우 객체 생성 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void throwExceptionOnMakingLineObject(int playerCounts) {
        assertThatThrownBy(() -> {
            Line.drawLine(playerCounts, new RandomDrawingLineStrategy());
        }).isInstanceOf(LadderBuildingException.class)
                .hasMessageContaining(LadderBuildingException.INVALID_PLAYER_COUNTS);
    }

    @DisplayName("Line 객체를 통해 그린 Line의 길이는 playerCounts - 1과 동일함")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15})
    public void lineSizeTest(int playerCounts) {
        Line line = Line.drawLine(playerCounts, new RandomDrawingLineStrategy());

        List<Boolean> pointPositions = line.getPointPositions();

        assertThat(pointPositions.size()).isEqualTo(playerCounts - 1);
    }
}
*/
