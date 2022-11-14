package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner sc = new Scanner(System.in);

    public String[] inputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
        String input = sc.nextLine();
        System.out.println();
        return input.split(DELIMITER);
    }

    public List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        System.out.println();
        return Arrays.asList(input.split(DELIMITER));
    }

    public String inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return nextLineWithNewLine();
    }

    private String nextLineWithNewLine() {
        String string = sc.nextLine();
        System.out.println();
        return string;
    }
}
