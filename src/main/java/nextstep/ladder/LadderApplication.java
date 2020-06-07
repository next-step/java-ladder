package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomMovementGenerator;
import nextstep.ladder.dto.LadderGameResultDto;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;
import java.util.Random;

public class LadderApplication {
    private static final String ALL = "all";

    public static void main(String[] args) {
        LadderRequestDto ladderRequestDto = InputView.inputLadderRequestDto();

        LadderGame ladderGame = new LadderGame(ladderRequestDto, new RandomMovementGenerator(new Random()));
        LadderResultDto ladderResultDto = ladderGame.getLadderResult();

        OutputView.outputLadderResult(ladderResultDto);
        List<LadderGameResultDto> ladderGameResultDtos = ladderGame.execute();
        String name = null;

        while (true) {
            name = InputView.inputNameForResult();
            if (name.equals(ALL)) {
                break;
            }
            OutputView.outputResults(ladderGameResultDtos, name);
        }
        OutputView.outputAllResult(ladderGameResultDtos);
    }
}
