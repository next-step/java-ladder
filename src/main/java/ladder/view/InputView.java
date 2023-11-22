package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ASK_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_RESULT_TARGET = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static InputView inputView() {
        return new InputView();
    }

    private InputView() {}

    public List<String> names() {
        System.out.println(ASK_NAMES);
        return splitedString();
    }

    public List<String> results() {
        System.out.println(ASK_RESULTS);
        return splitedString();
    }

    private List<String> splitedString() {
        return List.of(scanner.nextLine().split(DELIMITER));
    }

    public int ladderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public String resultTarget() {
        System.out.println(ASK_RESULT_TARGET);
        return scanner.nextLine();
    }

}
