package ladder;

import ladder.domain.Direction;
import ladder.domain.Point;
import ladder.domain.PointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointStrategyTest {
    @DisplayName("사다리 포인트 그리기전략의 방향결정 테스트")
    @Test
    void direction() {
        PointStrategy strategy = () -> new Point(0, new Direction(false, false));
        assertThat(strategy.point()).isEqualTo(new Point(0, new Direction(false, false)));
    }
}
