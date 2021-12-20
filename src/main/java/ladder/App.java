package ladder;

import ladder.UI.Controller;
import ladder.UI.InputView;
import ladder.UI.ResponseDto;
import ladder.UI.ResultView;

public class App {

    public static void main(String[] args) {
        ResponseDto responseDto = Controller.runLadderGame(InputView.inputParticipants(), InputView.inputLadderHeight());
        ResultView.printLadderGameResult(responseDto);
    }
}
