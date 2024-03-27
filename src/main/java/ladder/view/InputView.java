package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Participant;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_PARTICIPANT_TO_CHECK_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private final Scanner scanner = new Scanner(System.in);

    public List<Participant> inputParticipants() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String line = scanner.nextLine();
        return Arrays.stream(line.split(DELIMITER))
            .map(String::trim)
            .map(Participant::from)
            .collect(Collectors.toUnmodifiableList());
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> inputResults() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        String line = scanner.nextLine();
        return Arrays.stream(line.split(DELIMITER))
            .map(String::trim)
            .collect(Collectors.toUnmodifiableList());
    }

    public String inputParticipantToCheckResult() {
        System.out.println(INPUT_PARTICIPANT_TO_CHECK_RESULT_MESSAGE);
        return scanner.nextLine();
    }
}
