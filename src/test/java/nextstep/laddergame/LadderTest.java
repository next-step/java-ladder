package nextstep.laddergame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static int width = 4;
    private static int height = 5;
    private static Ladder ladder = new Ladder(width, height, DrawBridgeStrategy.DEFAULT_STRATEGY);

    @Test
    public void ladder_size_test() {
        List<Line> board = ladder.getBoard();

        assertThat(board).hasSize(height);
        assertThat(board.get(0).getLadderPieces()).hasSize(width);
    }
}