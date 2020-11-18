package nextstep.ladder.view;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PHRASE_FOR_MEMBER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PHRASE_FOR_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String PHRASE_FOR_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PHRASE_FOR_MEMBER_NAME_FOR_END_POINT = "결과를 보고 싶은 사람은?";

    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public List<String> getMemberNames() {
        output.println(PHRASE_FOR_MEMBER_NAMES);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int getLadderHeight() {
        output.println(PHRASE_FOR_LADDER_HEIGHT);
        return scanner.nextInt();
    }

    public List<String> getLadderResult() {
        output.println(PHRASE_FOR_LADDER_RESULT);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public String getMemberName() {
        output.println(PHRASE_FOR_MEMBER_NAME_FOR_END_POINT);
        return scanner.next();
    }
}
