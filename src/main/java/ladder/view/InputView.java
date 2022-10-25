package ladder.view;

import java.awt.print.Pageable;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static final String MSG_INPUT_CANDIDATE_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MSG_INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static String inputCandidateNames() {
        System.out.println(MSG_INPUT_CANDIDATE_NAMES);
        return scanner.nextLine();
    }

    public static Integer inputMaxLadderHeight() {
        System.out.println(MSG_INPUT_MAX_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

}
