package nextstep.ladder;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.ui.InputView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Players players = new Players(inputView.getPlayersName());

        int ladderHeight = inputView.getLadderHeight();

    }
}
