package laddergame;

import laddergame.domain.game.GameResult;
import laddergame.domain.game.LadderGame;
import laddergame.domain.game.Results;
import laddergame.domain.vo.Height;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomConnectGenerator;
import laddergame.domain.player.Players;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String[] names = InputView.inputPlayerNames();
        Players players = new Players(names);

        String[] executeResults = InputView.inputExecuteResult();
        Results results = new Results(executeResults);

        Height ladderHeight = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(ladderHeight, names.length, new RandomConnectGenerator());

        LadderGame ladderGame = new LadderGame(ladder);

        GameResult gameResult = ladderGame.generateGameResult(players, results);

        OutputView.printLadder(players, ladder, results);

        while (true) {
            String findName = InputView.inputFindResultName();

            if (findName.equals("all")) {
                break;
            }

            OutputView.printResult(gameResult.findByName(findName));
        }

        OutputView.printAllResult(gameResult.findAll());
    }
}
