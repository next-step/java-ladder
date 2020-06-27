package nextstep.ladder.view;

import java.util.List;

public class ResultView {

    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String NON_HORIZONTAL = "     ";


    public void printUserNames(List<String> userNames) {
        userNames.forEach(userName -> System.out.printf("%-6s", userName));
        System.out.println();
    }

    private void printLadder(List<List<Boolean>> ladder) {
        ladder.forEach(this::printHorizontalLine);
    }

    private void printHorizontalLine(List<Boolean> line) {
        line.forEach(point -> {
            System.out.print(VERTICAL);
            printHorizontal(point);
        });
        System.out.println(VERTICAL);
    }

    private void printHorizontal(Boolean hasLadder) {
        if (hasLadder) {
            System.out.print(HORIZONTAL);
            return;
        }
        System.out.print(NON_HORIZONTAL);
    }

    public void printResult(List<String> userNames, List<List<Boolean>> ladder) {
        printUserNames(userNames);
        printLadder(ladder);
    }
}
