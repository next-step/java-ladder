package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Height;
import ladder.domain.LadderResultValue;
import ladder.domain.Participant;
import ladder.domain.LadderResult;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_PARTICIPANT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_SELECT_RESULT = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";

    public static List<Participant> names() {
        System.out.println(INPUT_PARTICIPANT);
        return Arrays.stream(scanner.nextLine().split(DELIMITER))
                .map(Participant::from)
                .collect(Collectors.toList());
    }

    public static Height height() {
        System.out.println(INPUT_MAX_HEIGHT);
        return Height.from(Integer.parseInt(scanner.nextLine()));
    }

    public static LadderResultValue results() {
        System.out.println(INPUT_RESULT);
        return new LadderResultValue(
                Arrays.stream(scanner.nextLine().split(DELIMITER))
                        .map(LadderResult::from)
                        .collect(Collectors.toList())
        );
    }

    public static Participant selectResult() {
        System.out.println(INPUT_SELECT_RESULT);
        return Participant.from(scanner.nextLine());
    }
}
