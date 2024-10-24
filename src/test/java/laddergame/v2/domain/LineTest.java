package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    @DisplayName("라인을 이동하여 최종 위치를 반환받는다")
    @Test
    void move(){
        Position first = Position.first(true);
        Position next = first.next(false);
        Position last = next.last();
        Line line = new Line(List.of(first, next, last));
        /*
        위치0  위치1  위치2
         |-----|     |
        */
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
