package ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_FORMAT = "^[a-zA-Z]+(,[a-zA-Z]+)*$";
    private static final String OUTCOME_FORMAT = "^(꽝|[1-9][0-9]*)(,(꽝|[1-9][0-9]*))*$";
    private static final String HEIGHT_FORMAT = "^([1-9][0-9]*)$";

    public static String[] inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String names = SCANNER.nextLine();

        if (!names.matches(NAME_FORMAT)) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 다시 입력해주세요.");
        }

        return names.split(",");
    }

    public static String[] inputOutcomes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String outcome = SCANNER.nextLine();

        if(!outcome.matches(OUTCOME_FORMAT)) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 다시 입력해주세요.");
        }

        return outcome.split(",");
    }

    public static int inputMaxLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        String maxHeight = SCANNER.nextLine();

        if (!maxHeight.matches(HEIGHT_FORMAT)) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 사다리의 높이는 1이상의 숫자만 입력할 수 있습니다.");
        }

        return Integer.parseInt(maxHeight);
    }

    public static String inputParticipantNameForOutcome() {
        System.out.println("\n결과를 보고 싶은 사람은?");

        return SCANNER.nextLine();
    }

}

