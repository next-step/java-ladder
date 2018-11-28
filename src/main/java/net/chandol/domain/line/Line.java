package net.chandol.domain.line;

import net.chandol.domain.bridge.Bridges;
import net.chandol.domain.player.Player;
import net.chandol.value.Positive;

import static net.chandol.value.Positive.ZERO;
import static net.chandol.value.Positive.pos;

public class Line {
    private final Positive lineNumber;
    private final Player player;
    private final Bridges bridges;

    public Line(int idx, Player player, Bridges bridges) {
        this.lineNumber = pos(idx);
        this.player = player;
        this.bridges = bridges;
    }

    public int leftPaddingSize() {
        return playerNameHalfLength();
    }

    private int playerNameHalfLength() {
        return player.nameLength() / 2;
    }

    public int rightPaddingSize() {
        // 짝수일때에는 사다리라인길이를 고려하여 -1을 해준다.
        if (isEven()) {
            return playerNameHalfLength() - 1;
        }

        // 홀수일때는 정수형 나누기이므로 보정필요없음
        return playerNameHalfLength();
    }

    public boolean hasLeftBridge(Positive row) {
        if (lineNumber.equals(ZERO)){
            return false;
        }

        return bridges.hasBridge(lineNumber, row);
    }

    public boolean hasRightBridge(Positive row) {
        return bridges.hasBridge(lineNumber.increase(), row);
    }

    private boolean isEven() {
        return player.nameLength() % 2 == 0;
    }
}
