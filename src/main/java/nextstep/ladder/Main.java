package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.domain.Size;
import nextstep.ladder.handler.LadderHandler;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderHandler ladderHandler = new LadderHandler();

        Peoples peoples = inputView.requestPeopleName();
        Size size = inputView.requestLadderHeight(peoples.getPeoples().size());
        Ladder ladder = ladderHandler.makeLines(size);
        outputView.responseResult(peoples);
        outputView.responseLadder(ladder);
    }
}
