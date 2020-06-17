package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGameUsers ladderGameUsers = InputView.askParticipantsName();
        int maxPoint = InputView.askMaximumLadderHeight();

        LadderGame ladderGame = new LadderGame(new RandomLadderConnection());

        Ladder ladder = ladderGame.createLadder(ladderGameUsers, maxPoint);

        OutputView.drawLadder(ladder);

        LadderResult ladderResult = ladderGame.execute(ladder);
        LadderGameSnapshot snapshot = ladderResult.getResults().get(Point.of(maxPoint));
        System.out.println(snapshot);
    }
}
