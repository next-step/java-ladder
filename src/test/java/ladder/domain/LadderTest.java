package ladder.domain;

import ladder.domain.exception.ContinuousTrueStickSameHeightException;
import ladder.domain.exception.DifferentLineSizeException;
import ladder.domain.exception.LinesLessThanMinimumSizeException;
import ladder.domain.fixtrue.FixedLinesGenerator;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(createLines());
    }

    @DisplayName("생성할 때")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Create {

        @DisplayName("전략을 받아 사다리를 생성할 수 있다.")
        @Test
        void create_by_strategy() {
            Ladder expected = new Ladder(createLines());

            Ladder actual = new Ladder(new FixedLinesGenerator());

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("라인들이 null이거나 최소사이즈인 1보다 작으면 예외를 발생시킨다.")
        @ParameterizedTest
        @MethodSource("generateLinesLessThanMinimumSize")
        void validate_minimum_lines_size(List<Line> lines) {
            ThrowingCallable actual = () -> new Ladder(lines);

            assertThatThrownBy(actual)
                    .isExactlyInstanceOf(LinesLessThanMinimumSizeException.class)
                    .hasMessage("최소 라인들 사이즈보다 작습니다. 최소 사이즈 : 1");
        }

        private Stream<List<Line>> generateLinesLessThanMinimumSize() {
            return Stream.of(null, new ArrayList<>());
        }

        @DisplayName("같은 높이에 연속된 true 스틱이 있으면 예외가 발생한다.")
        @Test
        void validate_consecutive_sticks() {
            List<Line> lines = List.of(
                    Line.from(List.of(true, false, true)),
                    Line.from(List.of(false, false, true))
            );

            ThrowingCallable actual = () -> new Ladder(lines);

            assertThatThrownBy(actual)
                    .isExactlyInstanceOf(ContinuousTrueStickSameHeightException.class)
                    .hasMessage("같은 높이에 연속된 true 스틱이 존재합니다.");
        }

        @DisplayName("모든 라인 사이즈가 동일하지 않으면 예외가 발생한다.")
        @Test
        void validate_different_line_size() {
            List<Line> lines = List.of(
                    Line.from(List.of(true, false, true)),
                    Line.from(List.of(false, false))
            );

            ThrowingCallable actual = () -> new Ladder(lines);

            assertThatThrownBy(actual)
                    .isExactlyInstanceOf(DifferentLineSizeException.class)
                    .hasMessage("라인의 사이즈가 동일하지 않습니다.");
        }
    }

    @DisplayName("주어진 높이의 스틱들을 반환한다.")
    @Test
    void find_sticks_of_height() {
        List<Stick> expected = List.of(
                new Stick(false),
                new Stick(true),
                new Stick(false)
        );

        List<Stick> actual = ladder.findSticksOf(new LadderHeight(2));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사다리의 높이를 반환한다.")
    @Test
    void find_ladderHeight() {
        LadderHeight expected = new LadderHeight(3);

        LadderHeight actual = ladder.findHeight();

        assertThat(actual).isEqualTo(expected);
    }

    private List<Line> createLines() {
        List<Line> lines = new ArrayList<>();
        lines.add(Line.from(List.of(true, false, true)));
        lines.add(Line.from(List.of(false, true, false)));
        lines.add(Line.from(List.of(true, false, false)));
        return lines;
    }
}
