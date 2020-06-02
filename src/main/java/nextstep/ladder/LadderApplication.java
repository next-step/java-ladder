package nextstep.ladder;

import nextstep.ladder.domain.RandomBridgeGenerator;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Random;

public class LadderApplication {

    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputLadderRequestDto();
        LadderGame ladderGame = new LadderGame(ladderRequestDto, new RandomBridgeGenerator(new Random()));

        LadderResultDto ladderResultDto = ladderGame.getLadderResult();
        OutputView.outputLadderResult(ladderResultDto);
    }
}
