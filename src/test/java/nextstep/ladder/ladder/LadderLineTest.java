package nextstep.ladder.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("사다리 생성 테스트")
    @Test
    void create() {
        assertThat(LadderLine.of(5).size()).isEqualTo(5);
    }

    @DisplayName("line 을 move 했을 때의 값을 리턴한다.")
    @Test
    void move() {
        Point first = Point.first(TRUE);
        List<Point> points = Arrays.asList(
                first,
                first.next(FALSE),
                first.next(FALSE).next(TRUE)
        );
        LadderLine line = LadderLine.of(points);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isZero();
        assertThat(line.move(2)).isEqualTo(3);
    }
}