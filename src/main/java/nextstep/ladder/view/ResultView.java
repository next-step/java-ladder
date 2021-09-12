package nextstep.ladder.view;


import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.InterSpace;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.LadderStep;
import static  nextstep.ladder.domain.LadderGameResult.SHOW_ALL_RESULT_KEY;

public class ResultView {

    public static final String CROSS_LINE_STRING = "|-----";
    public static final String BLANK_LINE_STRING = "|     ";
    public static final int LABEL_PADDING_SIZE = 6;
    public static final String PLAYER_NAME_NOT_EXIST_MESSAGE = "해당되는 이름을 가진 플레이어가 없습니다.";
    public static final String All_RESULT_DELIMITER = " : ";
    public static final String LINE_BREAK = "\n";

    private ResultView() {
    }

    public static ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printLabelWithPadding(ladder.getPlayerNames());
        ladder.getLadderSteps().forEach(this::printLadderStep);
        printLabelWithPadding(ladder.getPrizeNames());
    }

    private void printLadderStep(LadderStep ladderStep) {
        String ladderStepString = createLadderStepString(ladderStep);
        System.out.println(ladderStepString);
    }

    private String createLadderStepString(LadderStep ladderStep) {

        return ladderStep.getInterSpaces().value().stream()
            .map(this::getLineString)
            .collect(Collectors.joining());
    }

    private String getLineString(InterSpace crossLine) {
        return crossLine.hasCrossLine() ? CROSS_LINE_STRING : BLANK_LINE_STRING;
    }

    private void printLabelWithPadding(List<String> labels) {
        String labelStringWithPadding = labels.stream()
            .map(label -> addRightPadding(label, LABEL_PADDING_SIZE))
            .collect(Collectors.joining());

        System.out.println(labelStringWithPadding);
    }

    public void printGameResult(LadderGameResult ladderGameResult) {

        while (true) {
            String playerName = InputView.askPlayerNameForResult();
            if (SHOW_ALL_RESULT_KEY.equals(playerName)) {
                showAllPlayersPrizes(ladderGameResult);
                break;
            }
            showWhoGotWhatPrize(playerName, ladderGameResult);
        }
    }

    private void showAllPlayersPrizes(LadderGameResult ladderGameResult) {
        String allResultString = ladderGameResult.getLadderGameResult().entrySet().stream()
            .map((entry) -> entry.getKey() + All_RESULT_DELIMITER + entry.getValue())
            .collect(Collectors.joining(LINE_BREAK));

        System.out.println(allResultString);
    }

    public static void showWhoGotWhatPrize(String playerName, LadderGameResult ladderGameResult) {

        String playerPrizeString = ladderGameResult.getLadderGameResult()
            .getOrDefault(playerName, PLAYER_NAME_NOT_EXIST_MESSAGE);

        System.out.println(playerPrizeString);
    }

    private String addRightPadding(String str, int size) {
        return String.format("%-" + size + "s", str);
    }

    private static class ResultViewHolder {
        private static final ResultView instance = new ResultView();
    }

}
