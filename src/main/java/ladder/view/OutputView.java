package ladder.view;


import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.enums.Numeric;

import java.util.Arrays;
import java.util.Map;

public class OutputView {
    private static final String WIDTH_LADDER = "-----";
    private static final String HEIGHT_LADDER = "|";
    private static final String EMPTY_WIDTH_LADDER = "     ";

    public void printParticipateInUsers(String[] userNames) {
        Arrays.stream(userNames).forEach(userName -> System.out.printf("%6s", userName));
        System.out.println();
    }

    public void printLadder(Lines lines) {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(drawOneLine(line));
        }
        System.out.print(sb);
    }

    public StringBuilder drawOneLine(Line line) {
        int position = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(EMPTY_WIDTH_LADDER);
        for (boolean isInstalledLadder : line.points()) {
            drawLadderByType(sb, isInstalledLadder, position++);
        }
        sb.append("\n");
        return sb;
    }

    public void printResult(String[] inputResult) {
        Arrays.stream(inputResult).forEach(resultName -> System.out.printf("%6s", resultName));
        System.out.println();
    }

    public void printUserResult(String result) {
        System.out.println("실행결과");
        System.out.println(result);
    }

    public void printUserResults(Map<String, String> results) {
        System.out.println("실행결과");
        results.forEach((user, gameResult) -> {
            System.out.println(user + " : " + gameResult);
        });
    }

    private void drawLadderByType(StringBuilder sb, boolean isLadder, int position) {
        if (isDrawHeightLadder(position, isLadder)) {
            sb.append(HEIGHT_LADDER);
        }
        if (isDrawWidthLadder(position, isLadder)) {
            sb.append(WIDTH_LADDER);
        }
        if (isDrawEmptySpace(position, isLadder)) {
            sb.append(EMPTY_WIDTH_LADDER);
        }
    }

    private boolean isDrawHeightLadder(int position, boolean isLadder) {
        return isHeightLadder(position) && isLadder;
    }

    private boolean isDrawWidthLadder(int position, boolean isLadder) {
        return !isHeightLadder(position) && isLadder;
    }

    private boolean isDrawEmptySpace(int position, boolean isLadder) {
        return !isHeightLadder(position) && !isLadder;
    }

    private boolean isHeightLadder(int position) {
        return position % Numeric.TWO.number() == Numeric.ZERO.number();
    }

}
