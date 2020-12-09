package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATE_EXPRESSION = ",";

    private static final String PARTICIPANT_PERSON_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_COMMENT = "최대 사다리 높이는 몇 개인가요?";

    private static final int MAX_USER_NAME_LENGTH = 5;

    private InputView() {
    }

    public static List<String> participantPerson() {
        System.out.println(PARTICIPANT_PERSON_COMMENT);
        String[] inputName = sc.next().split(SEPARATE_EXPRESSION);
        validateParticipantName(inputName);
        return Arrays.asList(inputName);
    }

    private static void validateParticipantName(String[] inputName) {
        for (String name : inputName) {
            if (name.length() > MAX_USER_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println(LADDER_HEIGHT_COMMENT);
        return sc.nextInt();
    }

}
