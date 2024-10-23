package nextstep.ladder;

import nextstep.ladder.domain.GameOrganizer;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResultGroup;
import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.output.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        PlayerGroup playerGroup = new PlayerGroup(inputView.players());
        LadderResultGroup ladderResultGroup = LadderResultGroup.of(inputView.ladderResults(), playerGroup.count());

        int height = inputView.ladderHeight();
        Ladder ladder = Ladder.of(height, playerGroup.count());

        MatchResult matchResult = GameOrganizer.getInstance().play(playerGroup, ladderResultGroup, ladder);

        Visible outputView = new OutputView();
        outputView.view(matchResult, ladder);
    }
}
