package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PlayerGroup playerGroup =  new PlayerGroup(inputView.players());
        int height = inputView.ladderHeight();

        Ladder ladder = Ladder.of(height, playerGroup.count());

        OutputView outputView = new OutputView();
        outputView.viewResult(playerGroup, ladder.ladderLines());
    }
}
