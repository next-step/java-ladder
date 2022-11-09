package ladder.frontEnd;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String ENTER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public List<String> askEnterNames() {
        System.out.println(ENTER_NAMES);
        return Arrays.stream(SCANNER.nextLine().split(COMMA_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int askEnterLadderHeight() {
        System.out.println(ENTER_LADDER_HEIGHT);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
