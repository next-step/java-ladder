package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String BLANK = " ";
    private static final String SEPARATOR = ",";
    private static final String INPUT_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개 인가요?";

    private InputView() {
    }

    public static List<String> inputPlayers() {
        System.out.println(INPUT_PLAYERS);
        return Arrays.asList(scanner.nextLine()
                .replaceAll(BLANK, "")
                .split(SEPARATOR));
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return scanner.nextInt();
    }
}
