package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static int width = 4;
    private static String heightString = "5";
    private static Integer heightNumber = Integer.parseInt(heightString);
    private static Height height = new Height(heightString);
    private static Ladder ladder = new Ladder(width, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
    private static int MAX_BRIDGE_COUNT = width / 2 * heightNumber;

    @Test
    public void ladder_size_test() {
        List<Line> lines = ladder.getLines();

        assertThat(lines).hasSize(heightNumber);
        assertThat(lines.get(0).getLadderPieces()).hasSize(width);
    }


    @Test
    public void ladder_bridge_count_test1() {
        Ladder ladder = new Ladder(width, height, DrawBridgeStrategy.DRAW_ALL);
        assertThat(getBridgeCount(ladder)).isEqualTo(MAX_BRIDGE_COUNT);
    }

    @Test
    public void ladder_bridge_count_test2() {
        Ladder ladder = new Ladder(width, height, DrawBridgeStrategy.DRAW_ANY);
        assertThat(getBridgeCount(ladder)).isEqualTo(0);
    }

    @Test
    public void ladder_bridge_count_test3() {
        Ladder ladder = new Ladder(width, height, DrawBridgeStrategy.DEFAULT_STRATEGY);
        assertThat(getBridgeCount(ladder)).isBetween(0, MAX_BRIDGE_COUNT);
    }

    private int getBridgeCount(Ladder ladder) {
        int bridgeCount = 0;
        for (Line line : ladder.getLines()) {
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