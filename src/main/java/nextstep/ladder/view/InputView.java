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

    public static List<String> inputUserNames() {
        System.out.println(ASKING_NAMES);
        String next = scanner.next();
        return Arrays.stream(next.split(",")).collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println(ASKING_HEIGHT);
        return scanner.nextInt();
    }
}
