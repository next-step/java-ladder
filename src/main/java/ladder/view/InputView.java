package ladder.view;

import ladder.domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAMES_DELIMITER = ",";
    private static final String HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";

    private final List<Name> names;
    private final Integer height;

    public InputView() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(NAMES_QUESTION);
            names = scanNames(scanner);

            System.out.println(HEIGHT_QUESTION);
            height = scanHeight(scanner);
        }
    }

    public List<Name> names() {
        return names;
    }

    public Integer height() {
        return height;
    }

    private List<Name> scanNames(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split(NAMES_DELIMITER))
                .map(Name::new)
                .collect(toList());
    }

    private Integer scanHeight(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
