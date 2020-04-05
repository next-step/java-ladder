package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputParameters();
        Ladder ladder = LadderGame.run(ladderRequestDto);
        ResultView.printLadder(ladder);
    }
}
