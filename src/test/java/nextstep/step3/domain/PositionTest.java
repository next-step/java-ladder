package nextstep.step3.domain;

import nextstep.step3.strategy.TestDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Position 테스트")
class PositionTest {

    private int userCount = 4;
    private int breath = 0;
    private List<Boolean> points = Arrays.asList(true, false, true);
    private Line line = new Line(userCount, new TestDrawLineStrategy(points));
    private Position position = new Position(breath);

    @DisplayName("Position 이동")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"1:1", "2:0", "3:1"})
    void movePosition(int moveCount, int currentBreath) {
        for (int i = 0; i < moveCount; i++) {
            position.movePosition(line);
        }
        assertThat(position.getBreath()).isEqualTo(currentBreath);
    }

    @DisplayName("사다리 범위가 넘는 Position 이동")
    @Test
    void movePositionException() {
        List<Line> lines = new ArrayList<>();
        lines.add(line);
        lines.add(line);
        lines.add(line);

        assertThatThrownBy(() -> {
            for (int i = 0; i < lines.size() + 1; i++) {
                position.movePosition(lines.get(i));
            }
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
