package ladder.domain;

import ladder.exception.IllegalHorizontalLineHeightException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class HorizontalLineTest {
    private final VerticalLine verticalLine0 = new VerticalLine(0);
    private final VerticalLine verticalLine1 = new VerticalLine(1);
    private final VerticalLine verticalLine2 = new VerticalLine(2);
    private final AdjacentVerticalLines adjacentVerticalLines = new AdjacentVerticalLines(verticalLine0, verticalLine1);

    @Test
    void 특정_인덱스의_세로선을_잇는_HorizontalLine을_만들_수_있다() {
        HorizontalLine horizontalLine = new HorizontalLine(adjacentVerticalLines, 0);

        assertThat(horizontalLine.getAdjacentVerticalLines().getLeftVerticalLine()).isEqualTo(verticalLine0);
        assertThat(horizontalLine.getAdjacentVerticalLines().getRightVerticalLine()).isEqualTo(verticalLine1);
        assertThat(horizontalLine.getHeight()).isEqualTo(0);
    }

    @Test
    void 왼쪽으로_맞닿은_세로선을_반환할_수_있다() {
        HorizontalLine horizontalLine = new HorizontalLine(adjacentVerticalLines, 0);

        assertThat(horizontalLine.getLeftVerticalLine()).isEqualTo(verticalLine0);
    }

    @Test
    void 오른쪽으로_맞닿은_세로선을_반환할_수_있다() {
        HorizontalLine horizontalLine = new HorizontalLine(adjacentVerticalLines, 0);

        assertThat(horizontalLine.getRightVerticalLine()).isEqualTo(verticalLine1);
    }

    @Test
    void 세로선과_맞닿아있는지_확인할_수_있다() {
        HorizontalLine horizontalLine = new HorizontalLine(adjacentVerticalLines, 0);

        assertThat(horizontalLine.isConnected(verticalLine0)).isTrue();
        assertThat(horizontalLine.isConnected(verticalLine1)).isTrue();
        assertThat(horizontalLine.isConnected(verticalLine2)).isFalse();
    }

    @Test
    void 음수_높이를_가지면_예외가_발생한다() {
        assertThatThrownBy(() -> new HorizontalLine(adjacentVerticalLines, -1))
                .isInstanceOf(IllegalHorizontalLineHeightException.class);
    }
}
