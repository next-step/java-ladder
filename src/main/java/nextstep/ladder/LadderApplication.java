package nextstep.ladder;

import nextstep.ladder.domain.bridge.RandomBridgeGenerator;
import nextstep.ladder.domain.ladder.LadderGame;
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

        LadderGame ladderGame = new LadderGame(ladderRequestDto, new RandomBridgeGenerator(new Random()));
        LadderResultDto ladderResultDto = ladderGame.getLadderResult();

        OutputView.outputLadderResult(ladderResultDto);
        List<LadderGameResultDto> ladderGameResultDtos = ladderGame.execute();
        String name = null;
        do {
            name = InputView.inputNameForResult();
            if (name.equals(ALL)) {
                OutputView.outputAllResult(ladderGameResultDtos);
                break;
            }
            OutputView.outputResults(ladderGameResultDtos, name);
        } while(!name.equals(ALL));
    }
}
