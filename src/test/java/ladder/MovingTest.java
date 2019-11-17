package ladder;

import ladder.domain.Moving;
import ladder.domain.MovingOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {
    Moving moving1;
    Moving moving2;
    Moving moving3;
    Moving moving4;
    Moving moving5;

    @BeforeEach
    void setUp() {
        moving1 = new Moving(false, true);
        moving2 = new Moving(false, true);
        moving3 = new Moving(false, false);
        moving4 = new Moving(true, false);
        moving5 = new Moving(true, false);
    }

    @Test
    @DisplayName("생성자 Equal 테스트")
    void moveConstructEqualTest() {
        assertThat(moving1).isEqualTo(moving2);
    }

    @Test
    @DisplayName("움직일 때 인덱스 값 테스트")
    void moveTest() {
        assertThat(MovingOperator.getPosition(moving1)).isEqualTo(1);
        assertThat(MovingOperator.getPosition(moving2)).isEqualTo(1);
        assertThat(MovingOperator.getPosition(moving3)).isEqualTo(0);
        assertThat(MovingOperator.getPosition(moving4)).isEqualTo(-1);
        assertThat(MovingOperator.getPosition(moving5)).isEqualTo(-1);
    }
}
