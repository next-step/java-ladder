package nextstep.step3.domain;

import nextstep.step3.strategy.TestDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Position 테스트")
class PositionTest {

    private int userCount = 4;
    private int breath = 0;
    private List<Boolean> points = Arrays.asList(true, false, true);
    private Line line = new Line(userCount, new TestDrawLineStrategy(points));
    private Position position = new Position(breath);

    @DisplayName("Position 이동")
    @Test
    void movePosition() {
        position.movePosition(line);
        assertThat(position.getBreath()).isEqualTo(1);
        position.movePosition(line);
        assertThat(position.getBreath()).isEqualTo(0);
    }
}
