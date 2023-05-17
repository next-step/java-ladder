package ladder.domain;

import ladder.exception.IllegalAdjacentVerticalLinesException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AdjacentVerticalLinesTest {
    private final VerticalLine verticalLine0 = new VerticalLine(0);
    private final VerticalLine verticalLine1 = new VerticalLine(1);
    private final VerticalLine verticalLine2 = new VerticalLine(2);

    @Test
    void 인접한_수직선들로_AdjacentVerticalLines를_만들_수_있다() {
        AdjacentVerticalLines adjacentVerticalLines = new AdjacentVerticalLines(verticalLine0, verticalLine1);

        assertThat(adjacentVerticalLines.getLeftVerticalLine()).isEqualTo(verticalLine0);
        assertThat(adjacentVerticalLines.getRightVerticalLine()).isEqualTo(verticalLine1);
    }

    @Test
    void 생성_시_순서에_관계없이_left_right를_구분할_수_있다() {
        AdjacentVerticalLines adjacentVerticalLines = new AdjacentVerticalLines(verticalLine1, verticalLine0);

        assertThat(adjacentVerticalLines.getLeftVerticalLine()).isEqualTo(verticalLine0);
        assertThat(adjacentVerticalLines.getRightVerticalLine()).isEqualTo(verticalLine1);
    }

    @Test
    void 각_수직선의_index_차이가_2_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> new AdjacentVerticalLines(verticalLine0, verticalLine2))
                .isInstanceOf(IllegalAdjacentVerticalLinesException.class);
    }
}
