package ladder.view;

import java.util.List;
import java.util.Scanner;

import static ladder.util.LadderMembersExpression.validateMemberNames;

public class InputView {
    private static final String INPUT_PARTICIPATE_PEOPLE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HOW_MANY_COUNT_MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> askParticipatedPeople() {
        System.out.println(INPUT_PARTICIPATE_PEOPLE_MESSAGE);
        return validateMemberNames(SCANNER.nextLine());
    }

    public static String askMaxLadderHeight() {
        System.out.println(HOW_MANY_COUNT_MAX_LADDER_HEIGHT_MESSAGE);
        return SCANNER.nextLine();
    }
}
