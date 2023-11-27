package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_PARTICIPANTS_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String INPUT_PATTERN_EXCEPTION = "참가자 이름들의_구분자를_콤마로_입력해주세요";
    private static final String INPUT_LADDER_HEIGHT_EXCEPTION = "사다리 높이는 숫자로 입력해주세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> names() {
        System.out.println(INPUT_PARTICIPANTS_NAME_MESSAGE);
        try {
            return Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(INPUT_PATTERN_EXCEPTION);
        }
    }

    public int height() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_LADDER_HEIGHT_EXCEPTION);
        }
    }
}
