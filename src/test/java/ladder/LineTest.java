package ladder;

import ladder.domain.Line;
import ladder.domain.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    public void Line_참여자수_Test(){
        assertThatThrownBy(() -> new Line(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 2명 이상이어야 합니다.");
    }
}
