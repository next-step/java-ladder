package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.LadderResultGroup;
import nextstep.ladder.domain.result.MatchResult;
import nextstep.ladder.domain.player.PlayerGroup;
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
