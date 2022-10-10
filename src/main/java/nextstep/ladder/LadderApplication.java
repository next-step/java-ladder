package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.ParticipationName;
import nextstep.ladder.domain.Result;
import nextstep.ladder.dto.ParticipationNameDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        final List<ParticipationName> participationNames = ParticipationName.from(InputView.inputName());
        final LadderCreator ladderCreator = LadderCreator.of(participationNames.size(), InputView.inputLadderHeight());
        final Ladder ladder = ladderCreator.start();
        ResultView.resultPrint(ParticipationNameDto.from(participationNames), Result.show(ladder));
    }
}
