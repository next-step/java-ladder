package nextstep.ladder.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> receiveUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        return Arrays.asList(input
                .replaceAll("\\s", "")
                .split(","));
    }

    public List<String> receiveExecutionResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        return Arrays.asList(input
                .replaceAll("\\s", "")
                .split(","));
    }

    public int receiveLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = SCANNER.nextLine();
        return parseInt(input);
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
