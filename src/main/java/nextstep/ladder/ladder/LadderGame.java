package nextstep.ladder.ladder;

import nextstep.ladder.player.Players;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void play() {
        players.getPlayers().forEach(ladder::move);
    }
}
