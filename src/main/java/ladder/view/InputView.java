package ladder.view;

import ladder.domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static List<Name> inputNames() {
        System.out.println(INPUT_NAMES);
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        return SCANNER.nextInt();
    }
}
