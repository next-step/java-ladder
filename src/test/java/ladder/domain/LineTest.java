package ladder.domain;

import ladder.domain.exception.DifferentLineSizeException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("Boolean들을 받아 생성할 수 있다.")
        @Test
        void from_boolean_list() {
            Line expected = new Line(
                    IntStream.range(0, 3)
                            .mapToObj(index -> new Stick(true))
                            .collect(Collectors.toList())
            );

            Line actual = Line.from(List.of(true, true, true));

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("전략과 높이를 받아 생성할 수 있다.")
        @Test
        void of() {
            Line expected = new Line(
                    IntStream.range(0, 3)
                            .mapToObj(index -> new Stick(true))
                            .collect(Collectors.toList())
            );

            Line actual = Line.of(new LadderHeight(3), () -> true);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("두 라인의 같은 높이의 스틱값이 true인 인덱스를 찾을 때")
    @Nested
    class FindIndexesBothTrue {

        @DisplayName("크기가 다르면 예외가 발생한다.")
        @Test
        void validate_size() {
            Line line1 = Line.from(List.of(true, false));
            Line line2 = Line.from(List.of(false));

            ThrowingCallable actual = () -> line1.findIndexesTrueStickOfSameIndex(line2);

            assertThatThrownBy(actual)
                    .isExactlyInstanceOf(DifferentLineSizeException.class)
                    .hasMessage("라인의 사이즈가 동일하지 않습니다.");
        }

        @DisplayName("둘 다 true인 인덱스들을 반환한다.")
        @Test
        void find_indexes_true_stick_of_same_index() {
            List<Integer> expected = List.of(2);
            Line line1 = Line.from(List.of(true, false, true, false));
            Line line2 = Line.from(List.of(false, true, true, false));

            List<Integer> actual = line1.findIndexesTrueStickOfSameIndex(line2);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("둘 다 true인 값이 없다면 빈 리스트를 반환한다.")
        @Test
        void not_match() {
            Line line1 = Line.from(List.of(true, false));
            Line line2 = Line.from(List.of(false, true));

            List<Integer> actual = line1.findIndexesTrueStickOfSameIndex(line2);

            assertThat(actual).isEqualTo(new ArrayList<>());
        }
    }

    @DisplayName("라인의 높이를 반환한다.")
    @Test
    void find_height() {
        LadderHeight expected = new LadderHeight(4);
        Line line = Line.from(List.of(true, false, true, false));

        LadderHeight actual = line.findHeight();

        assertThat(actual).isEqualTo(expected);
    }
}
