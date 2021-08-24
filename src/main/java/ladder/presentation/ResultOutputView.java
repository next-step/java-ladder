package ladder.presentation;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Users;

public class ResultOutputView {

    private static final String RESULT_COMMENT = "실행결과";

    private static final String LINE_PREFIX = "     ";

    private static final String LINE_POSTFIX = "|\n";

    private static final String CONNECTED_POINT = "|-----";

    private static final String NOT_CONNECTED_POINT = "|     ";

    public void output(Users users, Ladder ladder) {
        System.out.println(RESULT_COMMENT);
        System.out.println(getUsersOutput(users));
        System.out.println(getLadderOutput(ladder));
    }

    private String getUsersOutput(Users users) {
        return users.getAllNames()
                .stream()
                .map(this::getNameOutputFormat)
                .reduce("", (x, y) -> x + y);
    }

    private String getNameOutputFormat(String name) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < 6 - name.length(); i++) {
            indent.append(" ");
        }
        return indent + name;
    }

    private String getLadderOutput(Ladder ladder) {
        return ladder.getLines()
                .stream()
                .map(this::getLineOutputFormat)
                .reduce("", (x, y) -> x + y);
    }

    private String getLineOutputFormat(Line line) {
        String ladderOutput = line.getPoints().stream()
                .map(this::getConnectedPoint)
                .reduce("", (x, y) -> x + y);
        return LINE_PREFIX + ladderOutput + LINE_POSTFIX;
    }

    private String getConnectedPoint(Boolean isChecked) {
        if (isChecked) return CONNECTED_POINT;
        return NOT_CONNECTED_POINT;
    }

}
