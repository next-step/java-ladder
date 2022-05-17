package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Nested
    class getPoint_메서드는 {

        @Nested
        class boolean_목록이_주어질경우 {
            private List<Boolean> points;

            @BeforeEach
            void setUp() {
                this.points = Arrays.asList(true, false, false, true);
            }

            @Test
            void 라인_문자열을_리턴한다() {
                Line line = new Line(points);

                assertThat(line.getPoint()).isEqualTo("|-----|     |     |-----|\n");
            }
        }

        @Nested
        class booleanGenerator가_주어질경우 {

            @Test
            void 문자열_검증() {
                Members members = new Members("pobi,jason,pang,nem");
                Line line = new Line(members, () -> true);

                assertThat(line.getPoint()).isEqualTo("|-----|     |-----|\n");

                line = new Line(members, () -> false);
                assertThat(line.getPoint()).isEqualTo("|     |     |     |\n");
            }
        }
    }
}
