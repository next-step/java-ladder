package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String userNames = LadderInputView.inputUserNames();
        int height = LadderInputView.inputHeight();
        LadderService ladderService = new LadderService(userNames, height);
        Ladder ladder = ladderService.getLadder();

        LadderResultView ladderResultView = new LadderResultView();
        ladderResultView.printLadder(ladder.getUsers(), ladder.getLines());
    }
}
