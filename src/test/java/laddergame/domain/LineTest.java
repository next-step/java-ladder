package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("사다리판으로 이동한 위치")
    void move_next_index() {
        //given
        Line line = new Line(Arrays.asList(new Point(0, Direction.of(false, true))
                , new Point(1, Direction.of(true, false))
                , new Point(2, Direction.of(false, true))
                , new Point(3, Direction.of(true, false))));
        //then
        assertThat(line.nextIndex(0)).isEqualTo(1);
    }
}
