package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void move_라인에서_각_포인트의_이동결과를_반환한다() {
        Line line = new Line(true, false, false);

        assertThat(line.move(List.of(0, 1, 2, 3))).isEqualTo(List.of(1, 0, 2, 3));
    }
}
