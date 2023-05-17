package ladder.domain;

import ladder.exception.IllegalHorizontalLineHeightException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class HorizontalLinesTest {
    private final VerticalLine verticalLine0 = new VerticalLine(0);
    private final VerticalLine verticalLine1 = new VerticalLine(1);
    private final AdjacentVerticalLines adjacentVerticalLines = new AdjacentVerticalLines(verticalLine0, verticalLine1);
    private final HorizontalLine horizontalLine0 = new HorizontalLine(adjacentVerticalLines, 0);
    private final HorizontalLine horizontalLine1 = new HorizontalLine(adjacentVerticalLines, 1);
    private final Set<HorizontalLine> horizontalLineSet = Set.of(
            horizontalLine0, horizontalLine1
    );

    @Test
    void HorizontalLineSet와_최대_높이로_생성하여_이를_리스트로_반환할_수_있다() {
        assertThat(new HorizontalLines(horizontalLineSet, 3)
                .getHorizontalLineSet()
                .containsAll(horizontalLineSet)
        ).isTrue();
    }

    @Test
    void 높이별로_HorizontalLineSet를_반환할_수_있다() {
        HorizontalLines horizontalLines = new HorizontalLines(horizontalLineSet, 3);
        Set<HorizontalLine> horizontalLineSet0 = horizontalLines.getHorizontalLineSetByHeight(0);
        Set<HorizontalLine> horizontalLineSet1 = horizontalLines.getHorizontalLineSetByHeight(1);

        assertThat(horizontalLineSet0.contains(horizontalLine0)).isTrue();
        assertThat(horizontalLineSet0.contains(horizontalLine1)).isFalse();
        assertThat(horizontalLineSet1.contains(horizontalLine0)).isFalse();
        assertThat(horizontalLineSet1.contains(horizontalLine1)).isTrue();
    }

    @Test
    void 최대_높이를_반환할_수_있다() {
        assertThat(new HorizontalLines(horizontalLineSet, 3).getMaxHeight()).isEqualTo(3);
    }

    @Test
    void 최대_높이를_초과하는_horizontalLine이_있으면_예외가_발생한다() {
        HorizontalLine horizontalLine = new HorizontalLine(adjacentVerticalLines, 5);
        assertThatThrownBy(() -> new HorizontalLines(Set.of(horizontalLine), 3))
                .isInstanceOf(IllegalHorizontalLineHeightException.class);
    }
}
