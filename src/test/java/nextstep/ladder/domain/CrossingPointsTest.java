package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;
import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CrossingPointsTest {

    private DirectionStrategy connectableTrueStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return true;
        }
    };

    @Test
    @DisplayName("현재 좌표에서 이동할 수 있는 방향에 따른 결과의 좌표를 반환한다.")
    public void move() throws Exception {
        //given
        CrossingPoint first = CrossingPoint.first(connectableTrueStrategy);
        CrossingPoint second = first.next(connectableTrueStrategy);
        CrossingPoints crossingPoints = new CrossingPoints(Arrays.asList(first, second));

        //when
        int right = crossingPoints.move(0);
        int left = crossingPoints.move(1);

        then(right).isEqualTo(1);
        then(left).isEqualTo(0);
    }
}
