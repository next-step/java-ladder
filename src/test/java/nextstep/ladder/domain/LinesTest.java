package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class LinesTest {

    @Test
    @DisplayName("각 라인의 좌표들을 인자로 받아 모든 라인을 생성한다.")
    public void create() throws Exception {
        //given
        AllCrossingPointsForLines allCrossingPointsForLines = new AllCrossingPointsForLines(new RandomDirectionStrategy());
        List<CrossingPoints> allCrossPoints = allCrossingPointsForLines.allCrossingPoints(4, 5);
        Lines lines = Lines.from(allCrossPoints);

        //when
        List<Line> result = lines.lines();

        then(result).hasSize(5);
    }
}
