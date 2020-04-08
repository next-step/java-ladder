package nextstep.ladder;

import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResponseDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    private static final String PRINT_ALL = "all";
    private static final String DEFAULT = "";

    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputParameters();
        LadderResponseDto ladderResponseDto = LadderGame.makeLadder(ladderRequestDto);
        ResultView.printLadder(ladderResponseDto);
        String name = DEFAULT;
        while (!name.equals(PRINT_ALL)) {
            name = InputView.inputResultName();
            if (name.equals(PRINT_ALL)) {
                ResultView.printAllOutput(LadderGame.findAll(ladderResponseDto.getLadder()), ladderRequestDto);
                break;
            }
            ResultView.printOutput(LadderGame.findResult(ladderResponseDto.getLadder(), name), ladderRequestDto);
        }
    }
}
