package ladder.domain;

import java.util.List;

public class LadderGame {
    public static final String LADDER_WIDTH = "-----";
    public static final String LADDER_EMPTY_WIDTH = "     ";
    public static final String LADDER_SIDE = "|";
    public static final int DEFAULT_LADDER_WIDTH = 5;
    public static final int DEFAULT_DRAW_TIME = 1;
    private Players players;
    private Ladder ladder;

    public LadderGame(List<String> players,  String inputLevel, List<String> inputResults) {
        validate(players, inputResults);
        this.players = new Players(players);
        this.ladder = new Ladder(players.size(), Level.findLevel(inputLevel), inputResults);
    }

    protected LadderGame(List<String> players, Ladder ladder) {
        this.players = new Players(players);
        this.ladder = ladder;
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public PlayResults play() {
        return players.play(ladder);
    }

    public int maxWidthDrawTimes() {
        return getWidthDrawTimes();
    }

    private int getWidthDrawTimes() {
        return (players.maxNameLength() / DEFAULT_LADDER_WIDTH) + DEFAULT_DRAW_TIME;
    }

    private void validate(List<String> players, List<String> inputResults) {
        if(players.size() != inputResults.size()) {
            throw new IllegalArgumentException("실행결과가 터무니 없이 부족하군욧!");
        }
    }
}
