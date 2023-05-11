package nextstep;

import nextstep.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 라인의_길이는_참가자_수보다_1_작다() {

        Line line = new Line(4, () -> true);

        assertThat(line.points()).hasSize(3);
    }

    @Test
    void 가로_라인은_겹칠_수_없다() {

        Line line = new Line(3, () -> true);

        assertThat(line.points()).containsExactly(true, false);
    }
}
