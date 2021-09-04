package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LineTest {

    @Nested
    @DisplayName("한 point가 true라면 항상 다음 point는 false여야 한다.")
    class truePointNextFalseTest {

        // given
        private int userCount = 4;

        @Test
        @DisplayName("[항상 true를 생성할 경우]")
        void tureGenerateStrategy() {

            // given
            Line expected = new Line(Arrays.asList(new Point(0, true),
                new Point(1, false),
                new Point(2, true),
                new Point(3, false)));

            // when
            Line result = Line.generateRandomLine(userCount, () -> true);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("[항상 false를 생성할 때]")
        void falseGenerateStrategy() {

            // given
            Line expected = new Line(Arrays.asList(new Point(0, false),
                new Point(1, false),
                new Point(2, false),
                new Point(3, false)));

            // when
            Line result = Line.generateRandomLine(userCount, () -> false);

            // then
            assertThat(result).isEqualTo(expected);
        }

    }

}