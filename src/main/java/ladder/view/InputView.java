package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String COMMA = ",";
    public static final String JOIN_COUNT_PLAYERS_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    public static final String MAX_COUNT_LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static List<String> printInputNames() {
        System.out.println(JOIN_COUNT_PLAYERS_MSG);
        return Arrays.asList(sc.nextLine().split(COMMA));
    }

    public static int printInputLadderHeight() {
        System.out.println(MAX_COUNT_LADDER_HEIGHT_MSG);
        return sc.nextInt();
    }

}
