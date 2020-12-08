package ladder.view;

import ladder.controller.Controller;

/**
 * Created By mand2 on 2020-12-07.
 */
public class InputView {

    public static final String QUESTION_PARTICIPANTS_NAMES_LIST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String QUESTION_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static String askParticipantList() {
        System.out.println(QUESTION_PARTICIPANTS_NAMES_LIST);
        return Controller.SCANNER.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println(QUESTION_LADDER_HEIGHT);
        return Controller.SCANNER.nextInt();
    }

}
