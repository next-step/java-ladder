package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Nested
    class getPoints_메서드는 {

        @Nested
        class 라인목록이_주어질때 {
            private List<List<Boolean>> lineList;

            @BeforeEach
            void setUp() {
                this.lineList = Arrays.asList(
                        Arrays.asList(true, false, false, true),
                        Arrays.asList(true, false, true, false),
                        Arrays.asList(false, true, false, true),
                        Arrays.asList(false, false, true, false)
                );
            }

            @Test
            void 문자열_검증() {
                Lines lines = Lines.of(lineList);

                assertThat(lines.getPoints()).isEqualTo(
                        "|-----|     |     |-----|\n" +
                                "|-----|     |-----|     |\n" +
                                "|     |-----|     |-----|\n" +
                                "|     |     |-----|     |\n"
                );
            }
        }
    }
}
