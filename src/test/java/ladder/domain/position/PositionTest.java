package ladder.domain.position;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.line.Line;
import ladder.domain.moving.Moving;
import ladder.domain.position.Position;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 정지_이동하기() {
        assertThat(
            Position.of(0, 0).move((x,i) -> Moving.STOP, Line.of(i -> List.of(false, false), 3)))
            .isEqualTo(Position.of(0, 0));
    }

    @Test
    void 직진_이동하기() {
        assertThat(Position.of(0, 0).move((x,i) -> Moving.FORWARD, Line.of(i -> List.of(false, false), 3)))
            .isEqualTo(Position.of(1, 0));
    }

    @Test
    void 오른쪽_이동하기() {
        assertThat(Position.of(0, 0).move((x,i) -> Moving.RIGHT, Line.of(i -> List.of(false, false), 3)))
            .isEqualTo(Position.of(1, 1));
    }

    @Test
    void 왼쪽_이동하기() {
        assertThat(Position.of(0, 1).move((x,i) -> Moving.LEFT, Line.of(i -> List.of(false, false), 3)))
            .isEqualTo(Position.of(1, 0));
    }

    @Test
    void 위치생성() {
        assertThat(Position.of(0, 0)).isEqualTo(Position.of(0, 0));
    }

}
