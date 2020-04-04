package nextstep.ladder;

import java.util.stream.Collectors;

public class ResultView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NEW_LINE = ResultRadderText.NEW_LINE.getText();
    private static final String VERTICAL = ResultRadderText.VERTICAL.getText();
    private static final String BLANK = ResultRadderText.BLANK.getText();
    private static final String NO_LINE = ResultRadderText.NO_LINE.getText();
    private static final String LINE = ResultRadderText.LINE.getText();

    private static ResultView resultView = new ResultView();

    public static ResultView getResultView() {
        return resultView;
    }

    public String appendUserNames(Users users) {
        return users.getUsers()
                    .stream()
                    .map(user -> user.getName())
                    .map(name -> appendBlank(name))
                    .collect(Collectors.joining(BLANK));

    }

    public String appendLine(Line line) {

        String tempLine = (String) line.getPoints()
                                       .stream()
                                       .map(point -> drawLineByPoint((Point) point))
                                       .collect(Collectors.joining(VERTICAL));
        return NO_LINE + VERTICAL + tempLine + VERTICAL;
    }

    public String drawLineByPoint(Point point) {
        if (point.isNextPoint()) {
            return LINE;
        }
        return NO_LINE;
    }

    public String drawLadder(Users users, Ladder ladder) {
        String result = "";
        result += appendUserNames(users);
        result += NEW_LINE;
        result += appendLines(ladder);
        return result;
    }
    
    private String appendLines(Ladder ladder) {
        return (String) ladder.getLadder()
                              .stream()
                              .map(line -> appendLine((Line) line))
                              .collect(Collectors.joining(NEW_LINE));
    }

    private String appendBlank(String name) {
        int length = name.length();
        int repeatCount = MAX_NAME_LENGTH - length;
        for (int i = 0; i < repeatCount; i++) {
            name = BLANK + name;
        }

        return name;
    }

}
