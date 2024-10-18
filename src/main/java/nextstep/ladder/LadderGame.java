package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.output.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PlayerGroup playerGroup =  new PlayerGroup(inputView.players());
        int height = inputView.ladderHeight();

        Ladder ladder = Ladder.of(height, playerGroup.count());

        Visible outputView = new OutputView();
        outputView.view(playerGroup, ladder);
    }
}
