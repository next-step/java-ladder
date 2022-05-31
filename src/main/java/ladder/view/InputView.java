package ladder.view;

import ladder.domain.Height;
import ladder.domain.Positions;
import ladder.exception.InvalidCountOfPositionException;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidNameException;
import ladder.exception.NotSupportException;
import ladder.util.SplitUtil;

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

    public static Positions participantsNameView() {
        System.out.println(MESSAGE_INPUT_PARTICIPANTS_NAME);
        return inputValidParticipantsName();
    }

    private static Positions inputValidParticipantsName() {
        try {
            return validateParticipantsName();
        } catch (InvalidCountOfPositionException | InvalidNameException e) {
            System.out.println(e.getMessage());
            return inputValidParticipantsName();
        }
    }

    private static Positions validateParticipantsName() {
        return Positions.createPlayers(SplitUtil.split(scanner.nextLine()));
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

    public static Positions resultView(Positions positions) {
        System.out.println(MESSAGE_INPUT_RESULT);
        return inputValidResult(positions);
    }

    private static Positions inputValidResult(Positions positions) {
        try {
            return validateResult(positions);
        } catch (InvalidCountOfPositionException | InvalidNameException e) {
            System.out.println(e.getMessage());
            return inputValidResult(positions);
        }
    }

    private static Positions validateResult(Positions playerPositions) {
        Positions resultPositions = Positions.createResults(SplitUtil.split(scanner.nextLine()));
        if (!playerPositions.hasSameSize(resultPositions)) {
            throw new InvalidCountOfPositionException(String.format(MESSAGE_INVALID_RESULT_COUNT, playerPositions.count()));
        }
        return resultPositions;
    }

    public static String searchResult() {
        System.out.println(MESSAGE_INPUT_SEARCH);
        return scanner.nextLine();
    }
}
