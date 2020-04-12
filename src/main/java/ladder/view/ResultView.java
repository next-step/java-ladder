package ladder.view;

import ladder.domain.*;
import ladder.dto.GameInfo;
import ladder.dto.GameResult;
import ladder.dto.GameResults;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String LADDER_LINE_EXSIT = "|-----";
    private static final String LADDER_LINE_NONE = "|     ";

    public static void viewLadder(GameInfo gameInfo, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        viewPlayers(gameInfo.getPlayers());
        viewLines(ladder);
        viewPlayResults(gameInfo.getPrizes());
        System.out.println("\n");
    }

    private static void viewPlayers(Players players) {
        System.out.println(
                players.getPlayers().stream()
                        .map(n -> getNameWithFormat(n.getName()))
                        .collect(Collectors.joining())
        );
    }

    private static String getNameWithFormat(String name) {
        return String.format(PLAYER_NAME_FORMAT, name);
    }

    private static void viewLines(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        IntStream.range(0, lines.size())
                .forEach(i -> viewLineByHeight(lines.get(i)));
    }

    private static void viewLineByHeight(Line line) {
        System.out.print("     ");
        line.getPoints().stream()
                .forEach(point -> printLines(point.isDirection(Direction.RIGHT)));
        System.out.println();
    }

    private static void printLines(boolean isExistLine) {
        if (isExistLine) {
            System.out.print(LADDER_LINE_EXSIT);
            return;
        }
        System.out.print(LADDER_LINE_NONE);
    }

    private static void viewPlayResults(Prizes prizes) {
        System.out.println(
                prizes.getPrizes().stream()
                        .map(n -> getNameWithFormat(n.getPrize()))
                        .collect(Collectors.joining())
        );
    }

    public static void viewPlayerResult(GameResults gameResults, String name) {
        System.out.println("실행결과");
        System.out.println(Optional.ofNullable(gameResults.getResult(name))
                .orElse("없는 플레이어 입니다."));
        System.out.println();
    }

    public static void viewAllPlayerResult(GameResults gameResults) {
        System.out.println("전체 실행결과");
        gameResults.getGameResults().stream()
                .forEach(result -> System.out.println(result.getPlayerName() + " : " + result.getPrize()));
    }
}
