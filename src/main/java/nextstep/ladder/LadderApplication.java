package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.util.Validation.*;

public class LadderApplication {
    public static void main(String[] args) {
        String inputPlayers = InputView.inputPlayers();
        Players players = new Players(inputPlayers);
        Result result = new Result(InputView.inputResult());
        isValidResult(players, result);
        Height ladderHeight = InputView.inputLadderCount();
        Ladder ladder = new Ladder(players.size(), ladderHeight);
        ResultView.printLadderGame(players, ladder);
        ResultView.printResultGroup(result);
        LadderGame ladderGame = new LadderGame(players, ladder);
        Result gameResult = ladderGame.start(result);
        ResultView.printLadderGameResult(players, gameResult);
    }
}
