package nextstep.ladder.view;

import java.util.stream.Collectors;

import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.ResultRadderText;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

public class ResultView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ALL = "all";
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
        String tempLine = line.getPoints()
                              .stream()
                              .map(point -> drawLineByPoint(point))
                              .collect(Collectors.joining(VERTICAL));
        return NO_LINE + VERTICAL + tempLine + VERTICAL;
    }

    public String drawLineByPoint(Point point) {
        if (point.isNextPoint()) {
            return LINE;
        }
        return NO_LINE;
    }

    public String drawLadder(Users users, Ladder ladder, Results results) {
        String result = "";
        result += appendUserNames(users);
        result += NEW_LINE;
        result += appendLines(ladder);
        result += NEW_LINE;
        result += appendResults(results);
        return result;
    }

    public String drawLadder2(GameInfo gameInfo, Ladder ladder) {
        String result = "";
        result += appendUserNames(gameInfo.getUsers());
        result += NEW_LINE;
        result += appendLines(ladder);
        result += NEW_LINE;
        result += appendResults(gameInfo.getResults());
        return result;
    }

    public String appendResults(Results results) {
        return results.getResults()
                      .stream()
                      .map(result -> result.getResult())
                      .map(result -> appendBlank(result))
                      .collect(Collectors.joining(BLANK));
    }


    public void printLadder(GameInfo gameInfo, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        System.out.println(drawLadder2(gameInfo, ladder));
    }

    public void printPlayResult(Users paramUsers, String userName) {
        System.out.println("\n실행 결과");
        System.out.println(playResult(paramUsers, userName));
    }

    public String playResult(Users paramUsers, String userName) {
        if (ALL.equals(userName)) {
            return playAllResult(paramUsers);
        }
        return playResultByUser(paramUsers, userName);
    }

    public String playResultByUser(Users paramUsers, String userName) {
        return paramUsers.getUsers()
                         .stream()
                         .filter(user -> user.getName().equals(userName))
                         .findFirst()
                         .get()
                         .getResult();

    }

    public String playAllResult(Users paramUsers) {
        return paramUsers.getUsers()
                         .stream()
                         .map(user -> appendUserResult(user))
                         .collect(Collectors.joining(NEW_LINE));
    }

    private String appendLines(Ladder ladder) {
        return ladder.getLadder()
                     .stream()
                     .map(line -> appendLine(line))
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

    private String appendUserResult(User user) {
        return user.getName() + " : " + user.getResult();
    }

}
