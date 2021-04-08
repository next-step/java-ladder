package nextstep.ladder.view;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    public static final String GUIDE_LADDER_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표( , )로 구분하세요.";
    public static final String GUIDE_LADDER_INPUT_LADDER_SIZE = "\n최대 사다리 높이는 몇 개인가요?";
    public static final String GUIDE_LADDER_INPUT_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String GUIDE_LADDER_INPUT_USER = "\n결과를 보고 싶은 사람은?";
    private final Scanner in = new Scanner(System.in);

    public String inputParticipants() {
        out.println(GUIDE_LADDER_INPUT_PARTICIPANTS);
        return in.nextLine();
    }

    public String inputLadderRewards() {
        out.println(GUIDE_LADDER_INPUT_RESULT);
        return in.nextLine();
    }

    public String inputLadderHeight() {
        out.println(GUIDE_LADDER_INPUT_LADDER_SIZE);
        return in.nextLine();
    }

    public String inputUserResult() {
        out.println(GUIDE_LADDER_INPUT_USER);
        return in.nextLine();
    }
}
