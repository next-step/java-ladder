package ladder;

import ladder.domain.LadderService;
import ladder.dto.LadderCreateRequestDto;
import ladder.dto.LadderCreateResponseDto;
import ladder.dto.LadderResultRequestDto;
import ladder.dto.LadderResultResponseDto;
import ladder.view.input.InputView;
import ladder.view.result.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final LadderService ladderService;

    public LadderController(InputView inputView, ResultView resultView, LadderService ladderService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.ladderService = ladderService;
    }

    public void run() {
        LadderCreateRequestDto ladderCreateRequestDto = LadderCreateRequestDto.of(inputView.getUserNames(), inputView.getLadderResult(), inputView.getLadderHeight());
        LadderCreateResponseDto ladderCreateResponseDto = ladderService.createLadder(ladderCreateRequestDto);
        resultView.print(ladderCreateResponseDto.getLadderUsers(), ladderCreateResponseDto.getLadderLines(), ladderCreateResponseDto.getLadderResults());

        LadderResultRequestDto ladderResultRequestDto = LadderResultRequestDto.of(inputView.getResultUsername());
        LadderResultResponseDto ladderResultResponseDto = ladderService.startLadder(ladderResultRequestDto);
        resultView.print(ladderResultResponseDto.getLadderResult());
    }
}
