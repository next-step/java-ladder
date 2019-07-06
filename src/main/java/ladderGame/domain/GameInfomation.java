package ladderGame.domain;

public class GameInfomation {


    private Players players;
    private LadderResults ladderResults;

    private GameInfomation(Players players, LadderResults ladderResults) {
        this.players = players;
        this.ladderResults = ladderResults;
    }

    public static GameInfomation of(Players players, LadderResults ladderResults) {
        return new GameInfomation(players, ladderResults);
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
}
