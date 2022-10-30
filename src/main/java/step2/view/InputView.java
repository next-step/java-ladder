package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static final String USER_INPUT_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static List<String> inputUsers() {
        System.out.println(USER_INPUT_TEXT);
        return Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
    }
}
