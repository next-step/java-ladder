package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.strategy.PointStrategy;
import nextstep.ladder.strategy.RandomPointStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.requestMemberNames(), InputView.requestLadderHegiht());

        PointStrategy pointStrategy = new RandomPointStrategy();

        ResultView.responseInitMessage();
        ResultView.responseLadderMembers(ladderGame.getMembers());
        ResultView.responseLadder(ladderGame.generate(pointStrategy));
    }
}
