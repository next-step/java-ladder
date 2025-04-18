package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String DELIMITER = ",";
    public static final String MESSAGE_READ_PARTICIPANT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(" + DELIMITER + ")로 구분하세요)";
    public static final String MESSAGE_READ_LADDER_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String MESSAGE_READ_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipantNames() {
        System.out.println(MESSAGE_READ_PARTICIPANT_NAMES);
        String names = scanner.nextLine();
        return Arrays.stream(names.split(DELIMITER)).collect(Collectors.toList());
    }

    public List<String> readLadderResults() {
        System.out.println(MESSAGE_READ_LADDER_RESULTS);
        String results = scanner.nextLine();
        return Arrays.stream(results.split(DELIMITER)).collect(Collectors.toList());
    }

    public int readLadderHeight() {
        System.out.println(MESSAGE_READ_LADDER_HEIGHT);
        return scanner.nextInt();
    }


}
