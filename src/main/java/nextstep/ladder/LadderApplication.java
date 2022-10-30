package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.LadderWinningResultDto;
import nextstep.ladder.dto.ParticipationNameDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        final ParticipationNames participationNames = new ParticipationNames(InputView.inputParticipationNames());
        final List<String> resultNames = InputView.inputRunningResult();
        final LadderCreator ladderCreator = LadderCreator.of(participationNames.size(), InputView.inputLadderHeight());
        final Ladder ladder = ladderCreator.create();
        ResultView.resultPrint(ParticipationNameDto.from(participationNames), Result.show(ladder), resultNames);
        final LadderWinningResultDto ladderWinningResultDto = LadderWinningResultDto.of(ladder, participationNames.getName(), resultNames);
        while (true) {
            final String inputResult = InputView.inputResultName();
            ResultView.resultName(inputResult, ladderWinningResultDto);
            if (isExit(inputResult)) break;
        }
    }

    private static boolean isExit(final String inputResult) {

        return inputResult.equals("all");
    }
}
