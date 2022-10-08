package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAMES_DELIMITER = ",";

    public static List<String> scanNames() {
        System.out.println(NAMES_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Arrays.stream(scanner.nextLine()
                        .split(NAMES_DELIMITER))
                .map(InputView::validateName)
                .collect(toList());
    }

    private static String validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자이하 이어야 합니다");
        }

        return name;
    }
}
