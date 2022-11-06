package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUERY_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String QUERY_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAMES_SEPARATOR = ",";

    public static List<Name> queryNames() {
        System.out.println(QUERY_NAMES_MESSAGE);
        return Arrays.stream(scanner.nextLine().split(NAMES_SEPARATOR))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public static LadderMaxHeight queryMaxHeight() {
        System.out.println(QUERY_MAX_HEIGHT_MESSAGE);
        return new LadderMaxHeight(Integer.parseInt(scanner.nextLine()));
    }
}
