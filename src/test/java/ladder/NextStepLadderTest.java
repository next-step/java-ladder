package ladder;

import ladder.domain.engine.LadderGenerator;
import ladder.domain.engine.LineGenerator;
import ladder.domain.nextstep.NextStepLadderGenerator;
import ladder.domain.nextstep.NextStepLineGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NextStepLadderTest {
    @Test
    public void Ladder_높이_Test(){
        LineGenerator lineGenerator = new NextStepLineGenerator();
        LadderGenerator ladderGenerator = new NextStepLadderGenerator(lineGenerator);
        assertThatThrownBy(() -> ladderGenerator.generateLadder(3,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상이어야 합니다.");
    }
}
