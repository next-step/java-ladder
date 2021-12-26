package ladder;

import ladder.domain.ladder.Controller;
import ladder.UI.InputView;
import ladder.UI.ResponseDto;
import ladder.UI.ResultView;
import ladder.domain.ladder.LadderResult;

public class App {

    public static void main(String[] args) {
        ResponseDto responseDto =
                Controller.readyLadderGame(InputView.inputParticipants(),
                                         InputView.inputLadderResult(),
                                         InputView.inputLadderHeight()
                                         );
        ResultView.printLadderGame(responseDto);

        String name = InputView.inputFindByName();
        LadderResult ladderResult = Controller.play(responseDto);
        ResultView.printLadderGameResult(ladderResult, name);
    }
}
