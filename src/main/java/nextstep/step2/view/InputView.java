package nextstep.step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PARTICIPANT_NAME_DELIMITER = ",";

    public static String[] inputParticipantNames() {
        OutputView.printParticipantNamesNotification();

        return scanner.nextLine().split(PARTICIPANT_NAME_DELIMITER);
    }

    public static int inputLadderHeight() {
        OutputView.printLadderHeightNotification();

        return scanner.nextInt();
    }
}
