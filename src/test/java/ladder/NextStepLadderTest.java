package ladder;

import ladder.domain.nextstep.NextStepLadder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NextStepLadderTest {
    @Test
    public void Ladder_높이_Test(){
        assertThatThrownBy(() -> new NextStepLadder(3,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상이어야 합니다.");
    }
}
