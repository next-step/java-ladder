package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    static final String MESSAGE_FOR_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    static final String MESSAGE_FOR_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<String> inputNames() {
        System.out.println(MESSAGE_FOR_NAMES);
        return Arrays.asList(SCANNER.nextLine().split(","));
    }

    @Override
    public int inputHeight() {
        System.out.println(MESSAGE_FOR_HEIGHT);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
