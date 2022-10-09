package nextstep.laddergame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    public void ladder_size_test() {
        Ladder ladder = new Ladder(4, 5);
        List<List<LadderPiece>> board = ladder.getBoard();
        assertThat(board).hasSize(4);
        assertThat(board).hasSize(5);
    }

}