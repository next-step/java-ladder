package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Name;

public class InputView {

    private static final String NAME_DELIMITER = ",";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public List<Name> inputPariticipantNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String line = scanner.nextLine();
        return Arrays.stream(line.split(NAME_DELIMITER))
            .map(String::trim)
            .map(Name::of)
            .collect(Collectors.toUnmodifiableList());
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }
}
