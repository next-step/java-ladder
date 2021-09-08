package nextstep.ladder.view;


import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.InterSpace;
import nextstep.ladder.domain.LadderStep;
import nextstep.ladder.domain.Players;

public class ResultView {

    public static final String CROSS_LINE_STRING = "|-----";
    public static final String BLANK_LINE_STRING = "|     ";
    public static final int NAMES_PADDING_SIZE = 6;

    private ResultView() {
    }

    public static ResultView getInstance() {
        return ResultViewHolder.instance;
    }


    public void showLadderGame(Players players, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printPlayerNames(players);
        printLadder(ladder);
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

    private void printPlayerNames(Players players) {
        String playerNamesWithPadding = players.stream()
            .map(p -> addRightPadding(p.getName(), NAMES_PADDING_SIZE))
            .collect(Collectors.joining());

        System.out.println(playerNamesWithPadding);
    }

    private String addRightPadding(String str, int size) {
        return String.format("%-" + size + "s", str);
    }

    private static class ResultViewHolder {

        private static final ResultView instance = new ResultView();
    }


}
