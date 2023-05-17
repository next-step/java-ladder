package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String COMMON_DELIMITER = ",";

    public static List<String> inputNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return List.of(inputValue().split(COMMON_DELIMITER));
    }

    private static String inputValue() {
        return SCANNER.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        return Integer.parseInt(inputValue());
    }

    public static List<String> inputExecutionResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return List.of(inputValue().split(COMMON_DELIMITER));
    }

    public static String inputResultTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        return inputValue();
    }
}
