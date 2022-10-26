package nextstep.step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.step2.domain.ParticipantName;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PARTICIPANT_NAME_DELIMITER = ",";

    public static List<ParticipantName> inputParticipantNames() {
        OutputView.printParticipantNamesNotification();

        String[] participantNames = scanner.nextLine().split(PARTICIPANT_NAME_DELIMITER);
        return Arrays.stream(participantNames)
            .map(name -> ParticipantName.from(name))
            .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        OutputView.printLadderHeightNotification();

        return scanner.nextInt();
    }
}
