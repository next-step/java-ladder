package ladder.view;

import ladder.exception.InvalidNameOfParticipant;
import ladder.exception.InvalidNumberOfParticipants;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_OF_NAME_OF_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private InputView() {
    }

    public static String inputNames() {
        System.out.println(MESSAGE_OF_NAME_OF_PARTICIPANTS);
        return SCANNER.nextLine();
    }

    public static void validateNameOfParticipants(String[] names) {
        for (String name : names) {
            validateNameOfParticipants(name);
        }
    }

    private static void validateNameOfParticipants(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new InvalidNameOfParticipant(name);
        }
    }

    public static void validateNumberOfParticipants(String[] names) {
        if (names.length == 0 || names.length == 1) {
            throw new InvalidNumberOfParticipants();
        }
    }
}
