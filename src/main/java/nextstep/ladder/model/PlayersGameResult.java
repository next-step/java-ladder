package nextstep.ladder.model;


import java.util.List;
import java.util.Map;

public class PlayersGameResult {

    private List<Score> scoreList;

    public PlayersGameResult(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public static PlayersGameResult of(List<Score> scoreList) {
        return new PlayersGameResult(scoreList);
    }

    public String findResultByPlayer(Player player, GameResult gameResult) {
        Score playerScore = getScore(player);

        return gameResult.findResultByIndex(playerScore.intScore());
    }

    private Score getScore(Player player) {
        Score playerScore = scoreList.stream()
            .filter(score -> score.player().equals(player))
            .findFirst().get();
        return playerScore;
    }
}
