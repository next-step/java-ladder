package ladder.view;

import ladder.domain.Height;
import ladder.domain.Elements;
import ladder.exception.InvalidCountOfElementException;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidNameException;
import ladder.exception.NotSupportException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_INVALID_NUMBER_FORMAT = "숫자만 입력 가능합니다.";
    private static final String MESSAGE_INPUT_RESULT = "실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INVALID_RESULT_COUNT = "결과의 개수는 %d 이여야 합니다.";
    private static final String MESSAGE_INPUT_SEARCH = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new NotSupportException();
    }

    public static Elements participantsNameView() {
        System.out.println(MESSAGE_INPUT_PARTICIPANTS_NAME);
        return inputValidParticipantsName();
    }

    private static Elements inputValidParticipantsName() {
        try {
            return validateParticipantsName();
        } catch (InvalidCountOfElementException | InvalidNameException e) {
            System.out.println(e.getMessage());
            return inputValidParticipantsName();
        }
    }

    private static Elements validateParticipantsName() {
        return Elements.createPlayers(scanner.nextLine());
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

    public static Elements resultView(Elements elements) {
        System.out.println(MESSAGE_INPUT_RESULT);
        return inputValidResult(elements);
    }

    private static Elements inputValidResult(Elements elements) {
        try {
            return validateResult(elements);
        } catch (InvalidCountOfElementException | InvalidNameException e) {
            System.out.println(e.getMessage());
            return inputValidResult(elements);
        }
    }

    private static Elements validateResult(Elements playerElements) {
        Elements resultElements = Elements.createResults(scanner.nextLine());
        if (!playerElements.sameSize(resultElements)) {
            throw new InvalidCountOfElementException(String.format(MESSAGE_INVALID_RESULT_COUNT, playerElements.size()));
        }
        return resultElements;
    }

    public static String searchResult() {
        System.out.println(MESSAGE_INPUT_SEARCH);
        return scanner.nextLine();
    }
}
