package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class VerticalLineTest {

    @Test
    void shouldMovePosition() {
        VerticalLine verticalLine = new VerticalLine(List.of(new Direction(), new Direction()), new Position(1));
        LadderPosition ladderPosition = new LadderPosition(new Position(0));

        verticalLine.move(ladderPosition);

        assertThat(ladderPosition.getHorizontalPosition()).isEqualTo(new Position(0));
        assertThat(ladderPosition.length()).isEqualTo(2);
    }

    @Test
    void shouldReturnSamePosition() {
        VerticalLine line = new VerticalLine(List.of(new Direction()), new Position(0));

        assertThat(line.isSamePosition(new Position(0))).isTrue();
        assertThat(line.isSamePosition(new Position(1))).isFalse();
    }
}
