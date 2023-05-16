package nextstep;

import nextstep.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 가로_라인은_겹칠_수_없다() {

        // given
        Line line = new Line(3, () -> true);

        // when
        Stream<String> stringStream = line.booleanToLineStream();

        // then
        assertThat(stringStream).containsExactly("-----", "     ");
    }

    @Test
    void 사다리를_탈때_라인이_있는_방향으로_이동한다() {

        // given
        Line line = new Line(3, () -> true);

        // when
        int first = line.trace(0);
        int second = line.trace(1);
        int third = line.trace(2);

        // then
        assertThat(first).isEqualTo(1);
        assertThat(second).isEqualTo(0);
        assertThat(third).isEqualTo(2);
    }
}
