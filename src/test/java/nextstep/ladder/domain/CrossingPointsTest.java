package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CrossingPointsTest {

    @Test
    @DisplayName("플레이어 인원 수와 연결 전략을 인수로 받아 플레이어 인원 수 만큼의 현재 좌표를 생성한다.")
    public void create() throws Exception {
        //given
        CrossingPoints crossingPoints = new CrossingPoints(4, new RandomDirectionStrategy());

        //when
        List<CrossingPoint> result = crossingPoints.crossingPoints();

        then(result).hasSize(4);
    }
}
