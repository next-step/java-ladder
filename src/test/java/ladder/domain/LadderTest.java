package ladder.domain;

import ladder.exception.ContinuousHorizontalLineException;
import ladder.exception.NotEnoughVerticalLinesException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {
    private final int maxWidth = 3;
    private final int maxHeight = 2;
    private final VerticalLine verticalLine0 = new VerticalLine(0);
    private final VerticalLine verticalLine1 = new VerticalLine(1);
    private final AdjacentVerticalLines adjacentVerticalLines = new AdjacentVerticalLines(verticalLine0, verticalLine1);
    private final HorizontalLine horizontalLine = new HorizontalLine(adjacentVerticalLines, 0);
    private final VerticalLines verticalLines = new VerticalLines(Set.of(verticalLine0, verticalLine1), maxWidth);
    private final HorizontalLines horizontalLines = new HorizontalLines(Set.of(horizontalLine), maxHeight);

    @Test
    void 사다리는_최대_높이를_반환할_수_있다() {
        assertThat(new Ladder(verticalLines, horizontalLines).getHeight()).isEqualTo(maxHeight);
    }

    @Test
    void 사다리는_최대_너비를_반환할_수_있다() {
        assertThat(new Ladder(verticalLines, horizontalLines).getWidth()).isEqualTo(maxWidth);
    }

    @Test
    void 사다리는_세로선들을_반환할_수_있다() {
        assertThat(
                new Ladder(verticalLines, horizontalLines).getVerticalLines()
                        .getVerticalLineSet()
                        .containsAll(Set.of(verticalLine0, verticalLine1))
        ).isTrue();
    }

    @Test
    void 사다리는_가로선들을_반환할_수_있다() {
        assertThat(
                new Ladder(verticalLines, horizontalLines).getHorizontalLines()
                        .getHorizontalLineSet()
                        .contains(horizontalLine)
        ).isTrue();
    }

    @Test
    void 동일한_높이에서_연속되는_가로선이_존재하면_예외가_발생한다() {
        VerticalLine verticalLine2 = new VerticalLine(2);
        AdjacentVerticalLines adjacentVerticalLines12 = new AdjacentVerticalLines(verticalLine1, verticalLine2);
        HorizontalLine wrongHorizontalLine = new HorizontalLine(adjacentVerticalLines12, 0);

        assertThatThrownBy(() ->
                new Ladder(
                        new VerticalLines(
                                Set.of(verticalLine0, verticalLine1, verticalLine2),
                                maxWidth
                        ),
                        new HorizontalLines(
                                Set.of(horizontalLine, wrongHorizontalLine),
                                maxHeight
                        )
                )
        ).isInstanceOf(ContinuousHorizontalLineException.class);
    }

    @Test
    void 세로선이_하나_이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ladder(new VerticalLines(Set.of(verticalLine0), 1), horizontalLines))
                .isInstanceOf(NotEnoughVerticalLinesException.class);
    }
}
