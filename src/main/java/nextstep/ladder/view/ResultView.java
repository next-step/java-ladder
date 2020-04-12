package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.ImprovingPoint;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

public class ResultView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ALL = "all";
    private static final String NEW_LINE = "\n";
    private static final String VERTICAL = "|";
    private static final String BLANK = " ";
    private static final String NO_LINE = "     ";
    private static final String LINE = "-----";

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

    public String appendLine(LadderLine line) {
        StringBuilder stringBuilder = new StringBuilder(NO_LINE);

        List<ImprovingPoint> points = line.getPoints();

        String tempLine = line.getPoints()
                              .stream()
                              .map(point -> drawLineByPoint(point))
                              .collect(Collectors.joining(VERTICAL));

        return stringBuilder.append(VERTICAL)
                            .append(tempLine)
                            .toString();
    }

    public String drawLineByPoint(ImprovingPoint point) {
        if (point.getDirection().isRight()) {
            return LINE;
        }
        return NO_LINE;
    }

    public String drawLadder(GameInfo gameInfo, Ladder ladder) {
        return new StringBuilder().append(appendUserNames(gameInfo.getUsers()))
                                  .append(NEW_LINE)
                                  .append(appendLines(ladder))
                                  .append(NEW_LINE)
                                  .append(appendResults(gameInfo.getResults()))
                                  .toString();
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
        System.out.println(drawLadder(gameInfo, ladder));
    }

    public void printPlayResult(Users paramUsers, String userName) {
        System.out.println("\n실행 결과");
        System.out.println(playResult(paramUsers, userName));
    }

    public void repeatPrintPlayResult(Users resultsForAllPlayers) {
        InputView inputView = InputView.getInputView();
        while (true) {
            String userName = inputView.enterResultUser(resultsForAllPlayers);
            resultView.printPlayResult(resultsForAllPlayers, userName);
            if (ALL.equals(userName)) {
                break;
            }
        }
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            stringBuilder.append(BLANK);
        }
        return stringBuilder.append(name).toString();
    }

    private String appendUserResult(User user) {
        return user.getName() + " : " + user.getResult();
    }
}
