package ladder.controller;

import ladder.domain.Players;

public class LadderSize {
    private final long width;
    private final long height;

    private LadderSize(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(Players players, long height) {
        return new LadderSize(players.size() - 1, height);
    }

    public long width() {
        return width;
    }

    public long height() {
        return height;
    }
}
