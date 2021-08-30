package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderHeight;
import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reword.Rewords;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

    public static final String ALL_RESULT = "all";

    public static void main(String[] args) {
        Players players = InputView.inputNames();
        LadderHeight ladderHeight = InputView.inputHeightOfLadder();
        Rewords rewords = InputView.inputResult();

        Ladder ladder = Ladder.of(players, ladderHeight);

        ResultView.show(ladder.lines(), players);

        LadderResult ladderResult = LadderResult.of(ladder, rewords);

        String name;
        do {
            name = InputView.inputNameOfPlayer();
            askResult(players, ladderResult, name);
        } while (!name.equals(ALL_RESULT));
    }

    private static void askResult(Players players, LadderResult ladderResult, String name) {
        if (name.equals(ALL_RESULT)) {
            ResultView.results(ladderResult, players);
            return;
        }

        ResultView.result(ladderResult, players.findIndexByName(name));
    }
}
