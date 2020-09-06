package ladder.view;

import ladder.model.LadderResult;
import ladder.model.Line;
import ladder.model.User;

import java.util.List;

public class ResultView {
    private static final String LADDER_PHRASE = "사다리 결과";
    private static final String RESUlT_PHRASE = "실행결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String LADDER_FRONT_STRING = "   ";
    private static final String EMPTY_STEP_STRING = "     ";
    private static final String STEP_STRING = "-----";
    private static final String POINT_STRING = "|";
    private static final String RESULT_QUERY_FORMAT = "%s : %s";


    public void printLadderResultPhrase() {
        System.out.println(LADDER_PHRASE);
    }

    public void printResultPhrase() {
        System.out.println(RESUlT_PHRASE);
    }

    public void printLadderElements(List<String> elements) {
        elements.forEach(this::printElement);
        System.out.println();
    }

    private void printElement(String name) {
        System.out.printf(NAME_FORMAT, name);
    }

    public void printLadder(List<Line> lines) {
        lines.forEach(line -> {
            printLine(line.getSteps());
            System.out.println();
        });
    }

    private void printLine(List<Boolean> steps) {
        System.out.print(LADDER_FRONT_STRING);
        System.out.print(POINT_STRING);

        steps.forEach(step -> {
            System.out.print(getStepString(step));
            System.out.print(POINT_STRING);
        });
    }

    private String getStepString(boolean hasStep) {
        return hasStep ? STEP_STRING : EMPTY_STEP_STRING;
    }

    public void printResult(String target, LadderResult ladderResult) {
        String prize = ladderResult.getPrizeByUser(new User(target)).getPrize();
        System.out.println(String.format(RESULT_QUERY_FORMAT, target, prize));
    }

    public void printAllResults(List<String> userNames, LadderResult ladderResult) {
        userNames.forEach(userName -> printResult(userName, ladderResult));
    }

}
