package ladder.domain;

import ladder.exception.IllegalVerticalLineWidthException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class VerticalLinesTest {
    private final VerticalLine verticalLine0 = new VerticalLine(0);
    private final VerticalLine verticalLine1 = new VerticalLine(1);
    private final Set<VerticalLine> verticalLineSet = Set.of(verticalLine0, verticalLine1);

    @Test
    void VerticalLineSet를_반환할_수_있다() {
        assertThat(new VerticalLines(verticalLineSet, 2)
                .getVerticalLineSet()
                .containsAll(verticalLineSet)
        ).isTrue();
    }

    @Test
    void 최대_너비를_반환할_수_있다() {
        assertThat(new VerticalLines(verticalLineSet, 2).getMaxWidth()).isEqualTo(2);
    }

    @Test
    void 최대_너비를_초과하는_verticalLine이_있으면_예외가_발생한다() {
        VerticalLine verticalLine = new VerticalLine(5);
        assertThatThrownBy(() -> new VerticalLines(Set.of(verticalLine), 3))
                .isInstanceOf(IllegalVerticalLineWidthException.class);
    }

    @Test
    void 주어진_index에_해당하는_VerticalLine을_반환할_수_있다() {
        VerticalLines verticalLines = new VerticalLines(verticalLineSet, 2);

        assertThat(verticalLines.getVerticalLineByIndex(0)).isEqualTo(verticalLine0);
        assertThat(verticalLines.getVerticalLineByIndex(1)).isEqualTo(verticalLine1);
    }

    @Test
    void 주어진_index에_해당하는_VerticalLine이_없으면_null을_반환한다() {
        assertThat(new VerticalLines(verticalLineSet, 2).getVerticalLineByIndex(5)).isNull();
    }

    @Test
    void 숫자_만큼의_VerticalLine들을_만들_수_있다() {
        assertThat(VerticalLines.create(3).getSize()).isEqualTo(3);
    }
}
