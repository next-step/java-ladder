package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameSnapshot;
import nextstep.ladder.domain.RandomLadderConnection;
import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderResult;
import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Point;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGameUserStore ladderGameUserStore = InputView.askParticipantsName();
        int maxPoint = InputView.askMaximumLadderHeight();

        LadderGame ladderGame = new LadderGame(new RandomLadderConnection());

        Ladder ladder = ladderGame.createLadder(ladderGameUserStore, maxPoint);

        OutputView.drawLadder(ladder);

        LadderResult ladderResult = ladderGame.execute(ladder);
        LadderGameSnapshot snapshot = ladderResult.getResults().get(Point.of(maxPoint));
        System.out.println(snapshot);
    }
}
