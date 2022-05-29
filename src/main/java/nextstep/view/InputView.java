package nextstep.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import nextstep.ladder.domain.Height;

public class InputView {
    private static final String QUERY_NAME_OF_PARTICIPANT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String QUERY_NUMBER_OF_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputNameOfParticipant() {
        System.out.println(QUERY_NAME_OF_PARTICIPANT);
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public static Height inputNumberOfHeight() {
        System.out.println(QUERY_NUMBER_OF_HEIGHT);
        while (true) {
            try {
                return new Height(scanner.nextInt());
            } catch (Exception e) {
                System.out.printf("%s 다시 입력해주세요." + System.lineSeparator(), e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
