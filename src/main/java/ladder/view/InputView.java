package ladder.view;

import ladder.domain.People;
import ladder.exception.InvalidCountOfPersonException;
import ladder.exception.InvalidNameException;
import ladder.exception.NotSupportException;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new NotSupportException();
    }

    public static People participantsNameView() {
        System.out.println(MESSAGE_INPUT_PARTICIPANTS_NAME);
        return inputValidParticipantsName();
    }

    private static People inputValidParticipantsName() {
        try {
            return validateParticipantsName();
        } catch (InvalidCountOfPersonException | InvalidNameException e) {
            System.out.println(e.getMessage());
            return inputValidParticipantsName();
        }
    }

    private static People validateParticipantsName() {
        return new People(scanner.nextLine());
    }

}
