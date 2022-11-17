package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PARTICIPANT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String COMMA_SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getParticipants() {
        System.out.println(PARTICIPANT_MESSAGE);
        String[] inputs = scanner.nextLine().split(COMMA_SEPARATOR);
        return Arrays.stream(inputs).collect(Collectors.toList());
    }

    public static int getLadderHeight() {
        System.out.println();
        System.out.println(LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
