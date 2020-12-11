package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String LADDER_GAME_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_EXECUTE_MESSAGE = "실행 결과";
    private static final String LINE_FULL = "|-----";
    private static final String LINE_EMPTY = "|     ";
    private static final String PRINT_SEPARATOR = " : ";

    private ResultView() {}

    public static void printGameResult(Users users, Lines lines, GameReward reward) {
        System.out.println(LINE_SEPARATOR + LADDER_GAME_RESULT_MESSAGE + LINE_SEPARATOR);
        printGamePlayers(users);
        printLadderGame(lines);
        printRewards(reward);
    }

    private static void printGamePlayers(Users users) {
        List<User> userList = users.getUsers();
        userList.forEach(e -> System.out.print(stringRightAlign(e.getUserName()) + " "));
        System.out.println();
    }

    private static void printLadderGame(Lines lines) {
        List<Line> lineList = lines.getLines();
        IntStream.range(0,lineList.size())
                .forEach(i -> printLine(lineList.get(i)));
    }

    private static void printLine(Line line) {
        System.out.print("    ");
        parseBooleanToString(line.getPoints());
        System.out.println();
    }

    private static void parseBooleanToString(List<Point> points) {
        StringBuilder ladderLine = new StringBuilder();
        points.stream()
                .map(point -> isLineRight(point.getPointer()))
                .forEach(ladderLine::append);
        System.out.print(ladderLine.toString());
    }

    private static String isLineRight(Pointer pointer) {
        if (pointer.isRight()) {
            return LINE_FULL;
        }
        return LINE_EMPTY;
    }

    private static void printRewards(GameReward reward) {
        List<String> rewards = reward.getRewards();
        rewards.forEach(e -> System.out.print(stringRightAlign(e) + " "));
        System.out.println(LINE_SEPARATOR);
    }

    private static String stringRightAlign(String name) {
        if (name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        return String.format("%" + MAX_NAME_LENGTH + "s",name);
    }

    public static void printGameRewards(List<GameResult> gameResults) {
        System.out.print(LINE_SEPARATOR + RESULT_EXECUTE_MESSAGE + LINE_SEPARATOR);
        gameResults.forEach(ResultView::toPrint);
    }

    private static void toPrint(GameResult gameResult) {
        User user = gameResult.getUser();
        String reward = gameResult.getReward();
        System.out.println(user.getUserName() + PRINT_SEPARATOR + reward);
    }
}
