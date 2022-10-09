package nextstep.laddergame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    public void ladder_size_test() {
        int width = 4;
        int height = 5;

        Ladder ladder = new Ladder(width, height);

        List<Line> board = ladder.getBoard();
        assertThat(board).hasSize(height);
        assertThat(board.get(0).getLadderPieces()).hasSize(width);
    }

}