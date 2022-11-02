package nextstep.step2;

import nextstep.step2.domain.Height;
import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.ParticipantName;
import nextstep.step2.domain.ParticipantNames;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameApplication {

    public static void main(String[] args) {
        final String[] inputParticipantNames = InputView.inputParticipantNames();
        final ParticipantNames participantNames = ParticipantNames.from(toParticipantNames(inputParticipantNames));
        final Height ladderHeight = Height.from(InputView.inputLadderHeight());
        final Ladder ladder = Ladder.of(participantNames, ladderHeight);
        OutputView.printGameResult(ladder);
    }

    private static List<ParticipantName> toParticipantNames(String[] inputParticipantNames) {
        return Arrays.stream(inputParticipantNames)
                .map(name -> ParticipantName.from(name))
                .collect(Collectors.toList());
    }
}
