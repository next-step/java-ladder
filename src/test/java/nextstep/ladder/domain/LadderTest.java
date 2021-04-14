package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class LadderTest {

    @Test
    @DisplayName("라인 목록을 인자로 받아 사다리를 생성한다.")
    public void create() throws Exception {
        //given
        AllPointsForLines allPointsForLines = new AllPointsForLines(new RandomDirectionStrategy());
        List<Points> allPoints = allPointsForLines.allPoints(4, 5);
        Lines lines = Lines.from(allPoints);

        //when
        Ladder ladder = new Ladder(lines);

        then(ladder.height()).isEqualTo(5);
    }
}