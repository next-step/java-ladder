package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String input = inputView.inputEntryMember();
        int inputLadderHeight = inputView.inputLadderHeight();

        Names names = Names.from(input);
        Height height = new Height(inputLadderHeight);
        Ladder ladder = Ladder.of(names.entryMemberCount(), height, new RandomLineStrategy());

        ResultView outputView = new ResultView();
        outputView.gameResult(names, ladder);
    }
}
