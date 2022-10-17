package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.ParticipationNames;
import nextstep.ladder.domain.Result;
import nextstep.ladder.dto.ParticipationNameDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        final ParticipationNames participationNames = new ParticipationNames(InputView.inputName());
        final LadderCreator ladderCreator = LadderCreator.of(participationNames.size(), InputView.inputLadderHeight());
        final Ladder ladder = ladderCreator.create();
        ResultView.resultPrint(ParticipationNameDto.from(participationNames), Result.show(ladder));
    }
}
