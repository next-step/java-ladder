package ladderGame.dto;

import ladderGame.domain.LadderResults;
import ladderGame.domain.Players;
import ladderGame.domain.Position;

public class GameInformation {

    private Players players;
    private LadderResults ladderResults;

    private GameInformation(Players players, LadderResults ladderResults) {
        this.players = players;
        this.ladderResults = ladderResults;
    }

    public static GameInformation of(Players players, LadderResults ladderResults) {
        return new GameInformation(players, ladderResults);
    }

    public String getPlayerNameByPosition(Position position) {
        return players.getPlayerName(position);
    }

    public String getResultByPosition(Position position) {
        return ladderResults.getResult(position);
    }


    public int getNumberOfPlayer() {
        return players.size();
    }

    public Players getPlayers() {
        return this.players;
    }

    public LadderResults getLadderResults() {
        return this.ladderResults;
    }
}
