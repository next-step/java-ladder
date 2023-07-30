package nextstep.ladder.domain;

import java.util.Objects;

public class LadderGame {

    private static final String ALL_PLAYER = "all";

    private final Ladder ladder;
    private final WinningItems winningItems;

    public LadderGame(Ladder ladder, WinningItems winningItems) {
        this.ladder = ladder;
        this.winningItems = winningItems;
    }

    public LadderGameResult gameStart(String name) {
        if (Objects.equals(name, ALL_PLAYER)) {
            return new LadderGameResult(ladder.movePlayer(winningItems));
        }

        return new LadderGameResult(ladder.movePlayer(name, winningItems));
    }
}
