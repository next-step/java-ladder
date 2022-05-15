package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Nested
    class getPoints_메서드는 {

        @Test
        void 문자열을_리턴한다() {
            List<Line> lineList = Arrays.asList(
                    new Line(Arrays.asList(true, false, false, true)),
                    new Line(Arrays.asList(true, false, true, false)),
                    new Line(Arrays.asList(false, true, false, true)),
                    new Line(Arrays.asList(false, false, true, false))
            );
            Lines lines = new Lines(lineList);

            assertThat(lines.getPoints()).isEqualTo(
                    "|-----|     |     |-----|\n" +
                    "|-----|     |-----|     |\n" +
                    "|     |-----|     |-----|\n" +
                    "|     |     |-----|     |\n"
            );
        }
    }
}
