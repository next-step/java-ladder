package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String LADDER_USERNAME_DELIMITER = ",";
    private static final String LADDER_USERNAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] getUserName() {
        System.out.println(LADDER_USERNAME_INPUT_MESSAGE);
        return scanner.nextLine().split(LADDER_USERNAME_DELIMITER);
    }

    public static int getLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
