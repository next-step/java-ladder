package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    public void Ladder_높이_Test(){
        assertThatThrownBy(() -> new Ladder(3,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상이어야 합니다.");
    }
}
