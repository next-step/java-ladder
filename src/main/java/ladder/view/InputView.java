package ladder.view;

import ladder.domain.LadderHeight;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final String USERS_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static String inputUsers() {
        System.out.println(USERS_INPUT_MESSAGE);

        return SCANNER.nextLine();
    }

    public static LadderHeight inputHeight() {
        System.out.println(HEIGHT_INPUT_MESSAGE);

        return new LadderHeight(SCANNER.nextInt());
    }
}
