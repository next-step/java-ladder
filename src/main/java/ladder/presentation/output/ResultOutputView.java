package ladder.presentation.output;

import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Line;
import ladder.domain.Users;

public class ResultOutputView {

    private static final String EMPTY_STRING = "";

    private static final String RESULT_COMMENT = "실행결과";

    private static final String LINE_PREFIX = "     ";

    private static final String LINE_POSTFIX = "|\n";

    private static final String CONNECTED_POINT = "|-----";

    private static final String NOT_CONNECTED_POINT = "|     ";

    public void output(Users users, Ladder ladder, LadderResults ladderResults) {
        System.out.println(RESULT_COMMENT);
        System.out.println(usersOutput(users));
        System.out.println(ladderOutput(ladder));
        System.out.println(ladderResultsOutput(ladderResults));
    }

    private String usersOutput(Users users) {
        return users.allNames()
                .stream()
                .map(this::nameOutputFormat)
                .reduce(EMPTY_STRING, (x, y) -> x + y);
    }

    private String nameOutputFormat(String name) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < 6 - name.length(); i++) {
            indent.append(" ");
        }
        return indent + name;
    }

    private String ladderOutput(Ladder ladder) {
        String output = ladder.getLines()
                .stream()
                .map(this::lineOutputFormat)
                .reduce(EMPTY_STRING, (x, y) -> x + y);
        return output.substring(0, output.length() - 1);
    }

    private String lineOutputFormat(Line line) {
        String ladderOutput = line.getPoints().stream()
                .map(this::connectedPoint)
                .reduce(EMPTY_STRING, (x, y) -> x + y);
        return LINE_PREFIX + ladderOutput + LINE_POSTFIX;
    }

    private String connectedPoint(Boolean isChecked) {
        if (isChecked) return CONNECTED_POINT;
        return NOT_CONNECTED_POINT;
    }

    private String ladderResultsOutput(LadderResults ladderResults) {
        return ladderResults.allNames().stream()
                .map(this::ladderResultOutput)
                .reduce(EMPTY_STRING, (x, y) -> x + y);
    }

    private String ladderResultOutput(String result) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < 6 - result.length(); i++) {
            indent.append(" ");
        }
        return result + indent;
    }

}
