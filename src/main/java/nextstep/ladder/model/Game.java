package nextstep.ladder.model;

import nextstep.ladder.view.ResultFormatter;

public class Game {
    private final Players players;
    private final GamePrize gamePrize;
    private final GameResult gameResult;

    public Game(Players players, GamePrize gamePrize, GameResult gameResult) {
        this.players = players;
        this.gamePrize = gamePrize;
        this.gameResult = gameResult;
    }

    public String getFormattedPlayersName() {
        return players.getFormattedName();
    }

    public String getFormattedPrize() {
        return gamePrize.getFormattedResult();
    }

    public String getPrize(String playerName) {
        int playerPosition = players.getPosition(playerName);
        int resultPosition = gameResult.getOnePosition(playerPosition);
        return gamePrize.getPrize(resultPosition);
    }

    public String getFormattedResult() {
        ResultFormatter resultFormatter = new ResultFormatter();
        return resultFormatter.format(this);
    }

    public String getName(int position) {
        return players.getName(position);
    }

    public String getPrize(int position) {
        int resultPosition = gameResult.getOnePosition(position);
        return gamePrize.getPrize(resultPosition);
    }

    public int countOfPlayer() {
        return players.countOfPlayer();
    }
}
