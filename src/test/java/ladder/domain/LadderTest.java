package ladder.domain;

import ladder.domain.exception.ContinuousStickSameHeightException;
import ladder.domain.exception.DifferentLineSizeException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("같은 높이에 연속된 스틱이 있으면 예외가 발생한다.")
        @Test
        void validate_consecutive_sticks() {
            List<Line> lines = List.of(
                    Line.from(List.of(true, false, true)),
                    Line.from(List.of(false, false, true))
            );

            ThrowingCallable actual = () -> new Ladder(lines);

            assertThatThrownBy(actual)
                    .isExactlyInstanceOf(ContinuousStickSameHeightException.class)
                    .hasMessage("같은 높이에 연속된 스틱이 존재합니다.");
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
}
