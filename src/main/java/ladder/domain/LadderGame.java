package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(String players, int heightOfLadder) {
        this.players = new Players(players);
        this.ladder = LadderGenerator.generateLadder(heightOfLadder, this.players);
    }

    public List<Player> getPlayers(){
        return players.getPlayers();
    }

    public List<Line> getLadder(){
        return ladder.getLadder();
    }

}
