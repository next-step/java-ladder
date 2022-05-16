package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.LadderLine;
import nextstep.ladder.util.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @DisplayName("사다리의 한 행을 생성한다.")
    @Test
    void createLadderLineTest() {
        LadderLine ladderLine = LadderLine.from(5, new RandomConnectStrategy());
        System.out.println(ladderLine);
    }
}
