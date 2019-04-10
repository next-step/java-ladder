package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static final String LADDER_WIDTH = "-----";
    public static final String LADDER_EMPTY_WIDTH = "     ";
    public static final String LADDER_SIDE = "|";
    public static final int DEFAULT_LADDER_WIDTH = 5;
    public static final int DEFAULT_DRAW_TIME = 1;
    private Players players;
    private Ladder ladder;

    public LadderGame(List<String> players, int height) {
        this.players = new Players(players);
        this.ladder = new Ladder(players.size(), height);
    }

    protected LadderGame(List<String> players, Ladder ladder) {
        this.players = new Players(players);
        this.ladder = ladder;
    }

    public int maxWidthDrawTimes() {
        return getWidthDrawTimes();
    }

    private int getWidthDrawTimes() {
        return (players.maxNameLength() / DEFAULT_LADDER_WIDTH) + DEFAULT_DRAW_TIME;
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public List<PlayResult> play() {
        List<PlayResult> playerResults = new ArrayList<>();
        players.getPlayers().forEach(player -> {
            String playerName = player.getName();
            playerResults.add(new PlayResult(playerName, ladder.move(players.playerIndex(playerName))));
        });
        return playerResults;
    }
}
