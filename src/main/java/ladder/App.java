package ladder;

import ladder.UI.InputView;
import ladder.UI.RequestDto;
import ladder.UI.ResponseDto;
import ladder.UI.ResultView;
import ladder.domain.ladder.Controller;
import ladder.domain.ladder.LadderResult;

public class App {

    public static void main(String[] args) {
        RequestDto requestDto = new RequestDto(InputView.inputParticipants(), InputView.inputLadderResult(), InputView.inputLadderHeight());
        ResponseDto responseDto = Controller.readyLadderGame(requestDto);
        ResultView.printLadderGame(responseDto);

        String name = InputView.inputFindByName();
        LadderResult ladderResult = Controller.play(responseDto);
        ResultView.printLadderGameResult(ladderResult, name);
    }
}
