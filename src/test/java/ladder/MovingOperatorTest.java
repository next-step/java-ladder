package ladder;

import ladder.domain.Moving;
import ladder.domain.MovingOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingOperatorTest {

    @Test
    @DisplayName("무브 클래스의 포지션 값 가져오기")
    void positionTest() {
        assertThat(MovingOperator.getPosition(new Moving(false, false))).isEqualTo(0);
    }
}
