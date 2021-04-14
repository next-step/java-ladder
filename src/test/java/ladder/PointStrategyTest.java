package ladder;

import ladder.domain.Direction;
import ladder.domain.PointNew;
import ladder.domain.PointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointStrategyTest {
    @DisplayName("사다리 포인트 그리기전략의 방향결정 테스트")
    @Test
    void direction() {
        PointStrategy strategy = new PointStrategy() {
            @Override
            public Direction direction() {
                return Direction.RIGHT;
            }

            @Override
            public PointNew point() {
                return null;
            }
        };
        assertThat(strategy.direction()).isEqualTo(Direction.RIGHT);
    }
}
