package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.util.Validation.*;

public class LadderApplication {
    public static void main(String[] args) {
        String inputPlayers = InputView.inputPlayers();
        Players players = new Players(inputPlayers);
        Result result = new Result(InputView.inputResult());
        isValidResult(players, result);
        int ladderHeight = InputView.inputLadderCount();
        Ladder ladder = new Ladder(players.size(), ladderHeight);
        ResultView.printLadderGame(players, ladder);
        ResultView.printResultGroup(result);
        LadderGame ladderGame = new LadderGame(players, ladder);
        Result gameResult = ladderGame.start(result);
        ResultView.printLadderGameResult(players, gameResult);
    }
}
