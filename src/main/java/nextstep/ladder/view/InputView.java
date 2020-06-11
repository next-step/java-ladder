package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private static final String INPUT_USER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAXIMUM_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요";

    public static String[] inputUserName(){
        System.out.println(INPUT_USER_NAME_MESSAGE);
        String input = SCANNER.nextLine();
        return input.split(SEPARATOR);
    }

    public static int inputMaximumLadderHeight(){
        System.out.println(INPUT_MAXIMUM_LADDER_HEIGHT_MESSAGE);
        return SCANNER.nextInt();
    }
}
