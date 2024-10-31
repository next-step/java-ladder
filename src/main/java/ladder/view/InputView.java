package ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAMES_FORMAT = "^[a-zA-Z]+(,[a-zA-Z]+)*$";
    private static final String HEIGHT_FORMAT = "^([1-9][0-9]*)$";

    public static String[] inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");

        String names = SCANNER.nextLine();

        if (!names.matches(NAMES_FORMAT)) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 다시 입력해주세요.");
        }

        return names.split(",");
    }

    public static int inputMaxLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        String maxHeight = SCANNER.nextLine();

        if (!maxHeight.matches(HEIGHT_FORMAT)) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 사다리의 높이는 1이상의 숫자만 입력할 수 있습니다.");
        }

        return Integer.parseInt(maxHeight);
    }

}

