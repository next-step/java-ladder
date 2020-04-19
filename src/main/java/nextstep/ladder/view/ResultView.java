package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.ImprovingPoint;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.UserResult;
import nextstep.ladder.domain.Users;

public class ResultView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ALL = "all";
    private static final String NEW_LINE = "\n";
    private static final String VERTICAL = "|";
    private static final String BLANK = " ";
    private static final String NO_LINE = "     ";
    private static final String LINE = "-----";

    private static Scanner scanner = new Scanner(System.in);

    public static String appendUserNames(Users users) {
        return users.getUsers()
                    .stream()
                    .map(user -> user.getName())
                    .map(name -> appendBlank(name))
                    .collect(Collectors.joining(BLANK));

    }

    public static String appendLine(LadderLine line) {
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

    public static String drawLineByPoint(ImprovingPoint point) {
        if (point.getDirection().isRight()) {
            return LINE;
        }
        return NO_LINE;
    }

    public static String drawLadder(GameInfo gameInfo, Ladder ladder) {
        return new StringBuilder().append(appendUserNames(gameInfo.getUsers()))
                                  .append(NEW_LINE)
                                  .append(appendLines(ladder))
                                  .append(NEW_LINE)
                                  .append(appendResults(gameInfo.getResults()))
                                  .toString();
    }

    public static String appendResults(Results results) {
        return results.getResults()
                      .stream()
                      .map(result -> result.getResult())
                      .map(result -> appendBlank(result))
                      .collect(Collectors.joining(BLANK));
    }

    public static void printLadder(LadderGame ladderGame) {
        System.out.println("\n사다리 결과\n");
        System.out.println(drawLadder(ladderGame.getGameInfo(), ladderGame.getLadder()));
    }

    public static void printPlayResult(List<UserResult> paramUsers, String userName) {
        System.out.println("\n실행 결과");
        System.out.println(playResult(paramUsers, userName));
    }

    public static void repeatPrintPlayResult(List<UserResult> resultsForAllPlayers) {
        while (true) {
            String userName = enterResultUser(resultsForAllPlayers);
            printPlayResult(resultsForAllPlayers, userName);
            if (ALL.equals(userName)) {
                break;
            }
        }
    }

    public static String playResult(List<UserResult> paramUsers, String userName) {
        if (ALL.equals(userName)) {
            return playAllResult(paramUsers);
        }
        return playResultByUser(paramUsers, userName);
    }

    public static String playResultByUser(List<UserResult> paramUsers, String userName) {
        return paramUsers.stream()
                         .filter(user -> user.getName().equals(userName))
                         .findFirst()
                         .get()
                         .getResult();

    }

    public static String playAllResult(List<UserResult> paramUsers) {
        return paramUsers
                .stream()
                .map(result -> appendUserResult(result))
                .collect(Collectors.joining(NEW_LINE));
    }

    public static void validateResultUser(List<UserResult> users, String userName) {
        if (!users.contains(new UserResult(userName))) {
            throw new IllegalArgumentException("유저 목록에 해당 이름이 없습니다.");
        }
    }

    private static String enterResultUser(List<UserResult> results) {
        System.out.println("\n결과를 보고 싶은 사람은? ");
        String userName = scanner.next();
        if (ALL.equals(userName)) {
            return userName;
        }

        validateResultUser(results, userName);
        return userName;
    }

    private static String appendLines(Ladder ladder) {
        return ladder.getLadder()
                     .stream()
                     .map(line -> appendLine(line))
                     .collect(Collectors.joining(NEW_LINE));
    }

    private static String appendBlank(String name) {
        int length = name.length();
        int repeatCount = MAX_NAME_LENGTH - length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            stringBuilder.append(BLANK);
        }
        return stringBuilder.append(name).toString();
    }

    private static String appendUserResult(UserResult user) {
        return user.getName() + " : " + user.getResult();
    }
}
