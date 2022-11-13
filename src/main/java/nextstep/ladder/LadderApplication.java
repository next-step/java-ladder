package nextstep.ladder;

import nextstep.ladder.codeleesh.domain.*;
import nextstep.ladder.codeleesh.dto.LineDto;
import nextstep.ladder.codeleesh.view.LadderWinningResult;
import nextstep.ladder.codeleesh.dto.ParticipationNameDto;
import nextstep.ladder.codeleesh.view.InputView;
import nextstep.ladder.codeleesh.view.ResultView;
import nextstep.ladder.engine.LadderCreator;
import nextstep.ladder.factory.LadderFactoryBean;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        final LadderCreator ladderCreator = LadderFactoryBean.createLadderFactory();
        final ParticipationNames participationNames = new ParticipationNames(InputView.inputParticipationNames());
        final List<String> resultNames = InputView.inputRunningResult();
        final Ladder ladder = ladderCreator.create(participationNames.size(), InputView.inputLadderHeight());
        ResultView.resultPrint(ParticipationNameDto.from(participationNames), LineDto.from(ladder.getLines()), resultNames);
        final LadderWinningResult ladderWinningResultDto = LadderWinningResult.of(ladder, participationNames.getName(), resultNames);
        while (true) {
            final String inputResult = InputView.inputResultName();
            if (ResultView.checkResultName(inputResult, ladderWinningResultDto)) break;
        }
    }
}
