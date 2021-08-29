package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.util.Validation;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputPlayers = InputView.inputPlayers();
        Players players = new Players(inputPlayers);
        Result result = new Result(InputView.inputResult());
        Validation.isValidResult(players,result);
        int ladderHeight = InputView.inputLadderCount();
        Ladder ladder = new Ladder(players.size(), ladderHeight);
        ResultView.printLadderGame(players, ladder);
        String searchPlayer  = InputView.inputGameResultSearch();

    }
}
