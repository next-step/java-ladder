package nextstep.ladder.view;

public class OutputView {

    private static final String PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static void printParticipantMessage() {
        System.out.println(PARTICIPANT_NAMES_MESSAGE);
    }

    public static void printMaxLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT);
    }
}
