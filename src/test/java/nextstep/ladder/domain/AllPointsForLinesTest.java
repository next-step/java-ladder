package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class AllPointsForLinesTest {

    @Test
    @DisplayName("계산 시점에 플레이어 수와 사다리 높이를 인자로 받아 모든 라인에 필요한 좌표들을 생성한다.")
    public void create() throws Exception {
        //given
        AllPointsForLines allPointsForLines = new AllPointsForLines(new RandomConnectStrategy());

        //when
        List<Points> allPoints = allPointsForLines.allPoints(4, 5);

        then(allPoints).hasSize(5);
    }
}
