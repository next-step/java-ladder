package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        Players players = new Players(InputView.inputPerson());
        Results results = new Results(InputView.inputResult(), players.size());

        Ladder ladder = LadderFactory.createRandomLadder(InputView.inputLadderHeight(), players.countPlayers());

        OutputView.outputLadderResult(players, ladder, results);

        ladder.run(players);

        OutputView.outputResult(players, results, InputView.inputPlayerWhoWantGetResult());
    }

}
