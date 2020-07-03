package ladder;

import ladder.domain.Height;
import ladder.domain.Users;
import ladder.ui.InputView;
import ladder.utils.InputUtils;

public class LadderMain {

    public static void main(String[] args) {

        LadderController ladderController = new LadderController();

        Users users = InputView.inputUser();
        Height height = InputView.inputHeight();

        ladderController.drawLadderGame(height,users);


    }
}
