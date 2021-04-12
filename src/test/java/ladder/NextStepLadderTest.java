package ladder;

import ladder.domain.engine.LadderGenerator;
import ladder.domain.nextstep.NextStepLadder;
import ladder.domain.nextstep.NextStepLadderGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NextStepLadderTest {
    @Test
    public void Ladder_높이_Test(){
        LadderGenerator ladderGenerator = new NextStepLadderGenerator();
        assertThatThrownBy(() -> ladderGenerator.generateLadder(3,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상이어야 합니다.");
    }
}
