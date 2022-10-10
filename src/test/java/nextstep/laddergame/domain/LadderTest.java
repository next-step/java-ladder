package nextstep.laddergame.domain;

import nextstep.laddergame.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static List<String> gamer = Arrays.asList("pobi", "honux", "crong", "jk");
    private static int width = 4;
    private static int height = 5;
    private static Ladder ladder = new Ladder(gamer, height, DrawBridgeStrategy.DEFAULT_STRATEGY);

    @Test
    public void ladder_size_test() {
        List<Line> board = ladder.getBoard();

        assertThat(board).hasSize(height);
        assertThat(board.get(0).getLadderPieces()).hasSize(width);
    }

    @Test
    public void print_ladder() {
        ResultView.printLadder(ladder);
    }
}