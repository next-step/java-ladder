package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreCalculator {

    private final Players players;
    private final Ladder ladder;

    ScoreCalculator(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static ScoreCalculator of(Players players, Ladder ladder) {
        return new ScoreCalculator(players, ladder);
    }

    public PlayersGameResult playersGameResult() {
        List<Score> scoreList = players.list().stream()
            .map(player -> ScoreCalculator.of(this.players, this.ladder).calculateScore(player))
            .collect(Collectors.toList());

        return PlayersGameResult.of(scoreList);
    }

    private Score calculateScore(Player player) {
        Score score = Score.of(player, players.orderByPlayerName(player.name()));
        return ladder.lines()
            .stream()
            .reduce(score, (currentScore, rowLine) -> {
                Step currentStep = rowLine.step(currentScore.intScore());
                if (currentStep.currentStep()) {
                    return currentScore.addSCore();
                }
                if (currentStep.previousStep()) {
                    return currentScore.minusScore();
                }
                return currentScore;
            }, (score1, score2) -> score2);
    }

}
