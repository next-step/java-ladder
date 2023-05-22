package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class InputView {
    private static final Scanner scanner = new Scanner(in);
    public static final String ASKING_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String ASKING_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String ASKING_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String ASKING_PLAYERS = "결과를 보고 싶은 사람은?";

    public static List<String> inputUserNames() {
        System.out.println(ASKING_NAMES);
        String next = scanner.next();
        return Arrays.stream(next.split(","))
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println(ASKING_HEIGHT);
        return scanner.nextInt();
    }

    public static List<String> inputLadderResult() {
        System.out.println(ASKING_LADDER_RESULT);
        String next = scanner.next();
        return Arrays.stream(next.split(","))
                .collect(Collectors.toList());

    }

    public static String inputUserName() {
        System.out.println(ASKING_PLAYERS);
        return scanner.next();
    }
}
