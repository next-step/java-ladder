package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    public static Lines create(List<Line> lines) {
        return new Lines(lines);
    }

    @Nested
    class getPoints_메서드는 {

        @Test
        void Point_문자열을_리턴한다() {
            Lines lines = create(List.of(
                    LineTest.create(List.of(true, false, false, true)),
                    LineTest.create(List.of(true, false, true, false)),
                    LineTest.create(List.of(false, true, false, true)),
                    LineTest.create(List.of(false, false, true, false))
            ));

            assertThat(lines.getPoints()).isEqualTo(
                    "|-----|     |     |-----|\n" +
                            "|-----|     |-----|     |\n" +
                            "|     |-----|     |-----|\n" +
                            "|     |     |-----|     |\n"
            );
        }
    }
}
