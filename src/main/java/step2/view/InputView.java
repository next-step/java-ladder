package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String USER_INPUT_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_TEXT = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_SEPARATOR = ",";

    public static List<String> inputUsers() {
        System.out.println(USER_INPUT_TEXT);
        return Arrays.stream(sc.nextLine().split(NAME_SEPARATOR))
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println(HEIGHT_INPUT_TEXT);
        return sc.nextInt();
    }
}
