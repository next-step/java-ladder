package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LineGenerationStrategy;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.RandomLineGenerationStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.AskHeightOfLadderDto;
import nextstep.ladder.view.dto.AskParticipantNamesDto;
import nextstep.ladder.view.dto.LadderCreateResultDto;

public class LadderGameApp {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final AskParticipantNamesDto askParticipantNamesDto = inputView.askParticipantNames();
        final Names names = askParticipantNamesDto.getNames();

        final AskHeightOfLadderDto askHeightOfLadderDto = inputView.askHeightOfLadder();
        final int heightOfLadder = askHeightOfLadderDto.getHeight();

        final LineGenerationStrategy lineGenerationStrategy = new RandomLineGenerationStrategy();

        final Ladder ladder = Ladder.of(lineGenerationStrategy, names.getNamesSize(), heightOfLadder);

        final ResultView resultView = new ResultView();
        final LadderCreateResultDto ladderCreateResultDto = LadderCreateResultDto.of(names, ladder);
        resultView.showLadderCreateResult(ladderCreateResultDto);
    }
}
