package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGameUsers;
import nextstep.ladder.domain.RandomLadderDrawingMachine;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> userNames = InputView.askParticipantsName();
        int maxHeight = InputView.askMaximumLadderHeight();

        LadderGame ladderGame = new LadderGame(new RandomLadderDrawingMachine());

        Ladder ladder = ladderGame.createLadder(new LadderGameUsers(userNames), maxHeight);

        OutputView.drawLadder(ladder);
    }
}
