package laddarGame.view;

import java.util.Arrays;

public enum Ladder {
    LADDER(true, "|-----"),
    EMPTY(false, "|     ");

    private final boolean isLadder;
    private final String drawPoint;

    Ladder(boolean isLadder, String drawPoint) {
        this.isLadder = isLadder;
        this.drawPoint = drawPoint;
    }

    public static String valueOf(boolean isLadder) {
        return Arrays.stream(values())
                .filter(ladder -> ladder.IsLadder(isLadder))
                .findAny()
                .map(Ladder::getDrawPoint)
                .orElseGet(() -> EMPTY.drawPoint);
    }

    public boolean IsLadder(boolean isLadder) {
        return this.isLadder == isLadder;
    }

    public String getDrawPoint() {
        return drawPoint;
    }
}
