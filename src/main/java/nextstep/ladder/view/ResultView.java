package nextstep.ladder.view;


import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.InterSpace;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.LadderStep;

public class ResultView {

    public static final String CROSS_LINE_STRING = "|-----";
    public static final String BLANK_LINE_STRING = "|     ";
    public static final int LABEL_PADDING_SIZE = 6;

    private ResultView() {
    }

    public static ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public static void showGameResult(String playerName, LadderGameResult ladderGameResult) {
        String prizeName = ladderGameResult.getPrizeNamesByName(playerName);
        System.out.println(prizeName);
    }


    public void showLadderGame(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printLabelWithPadding(ladder.getPlayerNames());
        printLadder(ladder);
        printLabelWithPadding(ladder.getPrizeNames());
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadderSteps()
            .forEach(this::printLadderStep);
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

    private String addRightPadding(String str, int size) {
        return String.format("%-" + size + "s", str);
    }

    private static class ResultViewHolder {

        private static final ResultView instance = new ResultView();
    }


}
