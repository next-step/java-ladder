package nextstep.ladder.view;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEW_LINE + "실행결과" + NEW_LINE;

    private ResultView() {
    }

    public static void showLadder(LadderResult result) {
        System.out.println(RESULT_MESSAGE);

        System.out.println(result.getPlayerNames());
        System.out.println(result.getLadder());
    }
}
