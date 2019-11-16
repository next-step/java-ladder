package ladder;

import ladder.domain.Move;
import ladder.domain.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {

    @Test
    @DisplayName("무브 클래스의 포지션 값 가져오기")
    void positionTest() {
        assertThat(Moving.getPosition(new Move(false, false))).isEqualTo(0);
    }
}
