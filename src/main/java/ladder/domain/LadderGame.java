package ladder.domain;

import java.util.List;

public class LadderGame {
    public static final String LADDER_WIDTH = "-----";
    public static final String LADDER_EMPTY_WIDTH = "     ";
    public static final String PILLAR = "|";
    private Players players;
    private Ladder ladder;

    public LadderGame(List<String> players, int height) {
        this.players = new Players(players);
        this.ladder = new Ladder(players.size(), height);
    }

    public int ladderWidth() {
        return players.ladderWidth();
    }

    public List<Line> ladder() {
        return ladder.getLines();
    }

    public List<Player> players() {
        return players.getPlayers();
    }
}
