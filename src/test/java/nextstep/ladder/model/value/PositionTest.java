package nextstep.ladder.model.value;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(3, drawLine());
    }

    @Test
    @DisplayName("포지션 객체 생성 검증")
    void createTest() {
        Position position = new Position(1);

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 선에 따라 잘 이동 하는지 테스트")
    void moveTest() {
        /*
        사다리 모양
        0     1     2     3     4
        |-----|     |-----|     |
         */

        Position position = new Position(0);
        Position position1 = new Position(1);

        assertThat(position.move(line)).isEqualTo(position1);
        assertThat(position1.move(line)).isEqualTo(position);
    }

    @Test
    @DisplayName("위치 값에 음수 입력되었을 때 예외 검증")
    void minusExceptionTest() {
        assertThatThrownBy(() ->
                new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    private Random drawLine() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
    }
}
