package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Participant;
import ladder.domain.ParticipantGroup;
import ladder.pattern.RandomValueGenerator;
import ladder.pattern.ValueGenerateStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.Point.UNIT_HORIZONTAL_LINE_LENGTH;

public class LadderGameController {
    private static final ValueGenerateStrategy valueGenerateStrategy = new RandomValueGenerator();

    public static void main(String[] args) {
        List<String> participantNames = InputView.scanParticipantNames();
        ParticipantGroup participantGroup = new ParticipantGroup(participantNames.stream().map(name -> new Participant(new Name(name))).collect(Collectors.toList()));

        int height = InputView.scanLadderHeight();
        Ladder ladder = Ladder.create(participantGroup.participantsCount(), height, valueGenerateStrategy);

        int maxConnectionLineLength = participantGroup.maxParticipantNameLength();
        OutputView.printParticipants(participantNames, maxConnectionLineLength + UNIT_HORIZONTAL_LINE_LENGTH);
        OutputView.printLadder(ladder, maxConnectionLineLength);
    }
}
