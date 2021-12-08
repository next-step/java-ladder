package step4.view;

public class ResultView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과\n\n";
    private static final String PARTICIPANT_ALL_RESULT_MESSAGE = "실행 결과\n";

    public void ladderResult() {
        System.out.print(LADDER_RESULT_MESSAGE);
    }

    public void participantAllResult() {
        System.out.print(PARTICIPANT_ALL_RESULT_MESSAGE);
    }
}
