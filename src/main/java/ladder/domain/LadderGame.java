package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(String players, int heightOfLadder) {
        this.players = new Players(players);
        this.ladder = LadderGenerator.ladderGenerator(heightOfLadder, this.players);
    }

    public List<String> isPlayersNameList(){
        return players.isPlayersNameList();
    }

    public List<Line> isLadder(){
        return ladder.isLadderInfo();
    }

}
