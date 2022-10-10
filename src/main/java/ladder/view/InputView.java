package ladder.view;

import ladder.domain.Name;
import ladder.domain.Names;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAMES_DELIMITER = ",";
    private static final String HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";

    public static InputDto scan() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(NAMES_QUESTION);
            Names names = scanNames(scanner);

            System.out.println(HEIGHT_QUESTION);
            Integer height = scanHeight(scanner);

            return new InputDto(names, height);
        }
    }

    private static Names scanNames(Scanner scanner) {
        return new Names(Arrays.stream(scanner.nextLine()
                        .split(NAMES_DELIMITER))
                .map(Name::new)
                .collect(toList()));
    }

    private static Integer scanHeight(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
