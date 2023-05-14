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
}
