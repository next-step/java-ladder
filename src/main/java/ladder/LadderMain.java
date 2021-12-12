package ladder;

import ladder.service.LadderService;
import ladder.view.InputView;

public class LadderMain {
    public static void main(String[] args)  {
        String[] users = InputView.inputUserName();
        String ladderHeight = InputView.inputLadderHeight();
        LadderService ladderService = new LadderService(users, ladderHeight);
        ladderService.play();
    }
}
