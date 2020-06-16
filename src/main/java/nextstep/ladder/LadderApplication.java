package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGameUsers;
import nextstep.ladder.domain.RandomLadderDrawingMachine;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGameUsers ladderGameUsers = InputView.askParticipantsName();
        int maxHeight = InputView.askMaximumLadderHeight();

        LadderGame ladderGame = new LadderGame(new RandomLadderDrawingMachine());

        Ladder ladder = ladderGame.createLadder(ladderGameUsers, maxHeight);

        OutputView.drawLadder(ladder);
    }
}
