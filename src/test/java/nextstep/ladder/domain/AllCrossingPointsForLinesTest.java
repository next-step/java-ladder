package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class AllCrossingPointsForLinesTest {

    @Test
    @DisplayName("계산 시점에 플레이어 수와 사다리 높이를 인자로 받아 모든 라인에 필요한 좌표들을 생성한다.")
    public void create() throws Exception {
        //given
        AllCrossingPointsForLines allCrossingPointsForLines = new AllCrossingPointsForLines(new RandomDirectionStrategy());

        //when
        List<CrossingPoints> allCrossPoints = allCrossingPointsForLines.allCrossingPoints(4, 5);

        then(allCrossPoints).hasSize(5);
    }
}
