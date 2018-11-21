package ladder.domain;

import ladder.utils.LadderPointGeneratorByDifficulty;
import ladder.utils.PointGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    private static final String ALL = "all";

    public static void main(String[] args) {

        String playersName = InputView.inputPlayers();
        String playResults = InputView.inputLadderGameResult();
        String difficulty = InputView.inputDifficulty();

        LadderPlayers ladderPlayers = LadderPlayers.ofComma(playersName);
        LadderResult ladderResult = LadderResult.ofComma(playResults);

        PointGenerator pointGenerator = new LadderPointGeneratorByDifficulty(difficulty);
        Ladder ladder = new Ladder(pointGenerator);
        ladder.generateLadder(DifficultyType.of(difficulty).lineNumberByDifficultyType(), ladderPlayers.totalPlayerCount());

        ResultView.drawLadderPlayers(ladderPlayers);
        ResultView.drawLadder(ladder);
        ResultView.drawResults(ladderResult);

        LadderGame ladderGame = new LadderGame(ladder);
        GameResult result = ladderGame.playLadder(ladderPlayers, ladderResult);

        String playerName = InputView.inputShowLadderResult();

        if(playerName.equals(ALL)) {
            ResultView.printAllResults(result);
            return;
        }

        ResultView.showResults(playerName, result);
    }
}
