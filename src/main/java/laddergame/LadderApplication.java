package laddergame;

import laddergame.domain.game.GameResult;
import laddergame.domain.game.LadderGame;
import laddergame.domain.game.Prizes;
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
        Prizes prizes = new Prizes(executeResults);

        Height ladderHeight = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(ladderHeight, names.length, new RandomConnectGenerator());

        LadderGame ladderGame = new LadderGame(ladder);

        GameResult gameResult = ladderGame.startGame(players, prizes);

        OutputView.printLadder(players, ladder, prizes);

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
