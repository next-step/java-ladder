package nextstep.laddergame.domain;

import nextstep.laddergame.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static List<Gamer> gamers = Arrays.asList(
            new Gamer("pobi")
            , new Gamer("honux")
            , new Gamer("crong")
            , new Gamer("jk")
    );
    private static int width = 4;
    private static int height = 5;
    private static Ladder ladder = new Ladder(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
    private static int MAX_BRIDGE_COUNT = gamers.size() / 2 * height;

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

    @Test
    public void ladder_bridge_count_test1() {
        Ladder ladder = new Ladder(gamers, height, DrawBridgeStrategy.DRAW_ALL);
        assertThat(getBridgeCount(ladder)).isEqualTo(MAX_BRIDGE_COUNT);
    }

    @Test
    public void ladder_bridge_count_test2() {
        Ladder ladder = new Ladder(gamers, height, DrawBridgeStrategy.DRAW_ANY);
        assertThat(getBridgeCount(ladder)).isEqualTo(0);
    }

    @Test
    public void ladder_bridge_valid_test() {
        Ladder ladder = new Ladder(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
        assertThat(getBridgeCount(ladder)).isBetween(0, MAX_BRIDGE_COUNT);
    }

    private int getBridgeCount(Ladder ladder) {
        int bridgeCount = 0;
        for (Line line : ladder.getBoard()) {
            bridgeCount += getBridgeCount(line);
        }
        return bridgeCount;
    }

    private int getBridgeCount(Line line) {
        int bridgeCount = 0;
        for (LadderPiece ladderPiece : line.getLadderPieces()) {
            bridgeCount += getBridgeCount(ladderPiece);
        }

        // Bridge 하나는 양쪽 Piece 에 의해 각각 한번씩 총 두번 카운트되기 때문에 /2 를 해줌.
        return bridgeCount / 2;
    }

    private int getBridgeCount(LadderPiece ladderPiece) {
        int bridgeCount = 0;
        if (ladderPiece.isRightBridge()) {
            bridgeCount++;
        }
        if (ladderPiece.isLeftBridge()) {
            bridgeCount++;
        }
        return bridgeCount;
    }
}