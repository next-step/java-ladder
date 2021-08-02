package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        int ladderHeight = InputView.inputLadderHeight();
        LadderGame ladderGame = LadderGame.of(LadderGameInfo.of(playerNames, ladderHeight));
    }

}
