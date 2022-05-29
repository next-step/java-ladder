package nextstep.ladder.view;

import nextstep.ladder.doman.LadderGame;
import nextstep.ladder.doman.Participants;

public class OutputView {

    private static final String PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTE_MESSAGE = "실행 결과";
    private static final StringBuilder stringBuilder = new StringBuilder();


    public static void printParticipantMessage() {
        System.out.println(PARTICIPANT_NAMES_MESSAGE);
    }

    public static void printMaxLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT);
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void printPersons(Participants participants) {
        System.out.println(participants.toString());
    }

    public static void printExecuteMessage() {
        stringBuilder.setLength(0);
        stringBuilder.append("\n")
                .append(EXECUTE_MESSAGE)
                .append("\n");
        System.out.println(stringBuilder);
    }
}
