package ladder.view;

import ladder.domain.Height;
import ladder.domain.People;
import ladder.exception.InvalidCountOfPersonException;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidNameException;
import ladder.exception.NotSupportException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_INVALID_NUMBER_FORMAT = "숫자만 입력 가능합니다.";

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

    public static Height ladderHeightView() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return inputValidLadderHeight();
    }

    private static Height inputValidLadderHeight() {
        try {
            return validateLadderHeight();
        } catch (InvalidHeightException e) {
            System.out.println(e.getMessage());
            return inputValidLadderHeight();
        }
    }

    private static Height validateLadderHeight() {
        return new Height(inputInt());
    }

    private static int inputInt() {
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException me) {
            System.out.println(MESSAGE_INVALID_NUMBER_FORMAT);
            scanner.nextLine();
            return inputInt();
        }
    }

}
