package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String COMMA = ",";
    public static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputNames() {
        System.out.println(INPUT_NAMES);
        List<String> input = Arrays.stream(scanner.nextLine().split(COMMA))
                .collect(Collectors.toList());
        System.out.println();

        return input;
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        int input = scanner.nextInt();
        System.out.println();

        return input;
    }
}
