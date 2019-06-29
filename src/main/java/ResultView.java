public class ResultView {
    private static final String LUNCH_RESULT_TEXT = "실행결과";

    private ResultView() {/*prevent creating instance.*/}

    public static void printLunchResult(LadderPlayerNames ladderPlayerNames, Ladder ladder) {
        System.out.println(LUNCH_RESULT_TEXT);
        System.out.println(ladderPlayerNames);
        System.out.println(ladder);
    }
}
