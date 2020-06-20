package ladder;

import ladder.domain.*;
import ladder.dto.LadderRequestDto;
import ladder.dto.LadderResponseDto;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameMain {
    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputParameters();
        LadderResponseDto ladderResponseDto = LadderGameService.play(ladderRequestDto);

        ResultView.printLadder(ladderResponseDto);
    }
}
