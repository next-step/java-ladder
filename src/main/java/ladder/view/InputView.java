package ladder.view;

import ladder.exception.InvalidHeightOfLadderException;

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

    public static int inputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(SCANNER.nextLine());
        return height;
    }

    public static void validateHeightOfLadder(int heightOfLadder) {
        if (heightOfLadder == 0) {
            throw new InvalidHeightOfLadderException(heightOfLadder);
        }
    }
}
