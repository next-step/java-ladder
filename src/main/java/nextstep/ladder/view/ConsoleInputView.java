package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String PARTICIPANT_NAMES_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAME_DELIMITER = ",";
    private static final String HEIGHT_INPUT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String ERROR_MSG_PREFIX = "[ERROR] ";
    private final Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public List<String> getParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_INPUT_MSG);
        String namesInput = scanner.nextLine();
        return Arrays.stream(namesInput.split(NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    @Override
    public int getHeight() {
        System.out.println(HEIGHT_INPUT_MSG);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void printError(RuntimeException e) {
        System.out.println(ERROR_MSG_PREFIX + e.getMessage());
    }
}
