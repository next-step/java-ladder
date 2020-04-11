package ladder.view;

import ladder.domain.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String LADDER_LINE_EXSIT = "|-----";
    private static final String LADDER_LINE_NONE = "|     ";

    public static void viewLadder(Players players, PlayResults playResults, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        viewPlayers(players);
        viewLines(ladder);
        viewPlayResults(playResults);
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
        IntStream.rangeClosed(1, ladder.getHeight())
                .forEach(i -> viewLineByHeight(ladder.getVerticalLines(), i));
    }

    private static void viewLineByHeight(VerticalLines verticalLines, int height) {
        System.out.print("     ");
        IntStream.rangeClosed(1, verticalLines.getSize())
                .forEach(i -> printLines(verticalLines.getLine(i).isDrawing(height)));
        System.out.println();
    }

    private static void printLines(boolean isExistLine) {
        if (isExistLine) {
            System.out.print(LADDER_LINE_EXSIT);
            return;
        }
        System.out.print(LADDER_LINE_NONE);
    }

    private static void viewPlayResults(PlayResults playResults) {
        System.out.println(
                playResults.getPlayResults().stream()
                        .map(n -> getNameWithFormat(n.getResult()))
                        .collect(Collectors.joining())
        );
    }

    public static void viewPlayerResult(LadderGameResult ladderGameResult, String name) {
        System.out.println("실행결과");
        System.out.println(Optional.ofNullable(ladderGameResult.getPlayerResult(name))
                .orElse("없는 플레이어 입니다."));
        System.out.println();
    }

    public static void viewAllPlayerResult(LadderGameResult ladderGameResult) {
        System.out.println("전체 실행결과");
        ladderGameResult.getPlayerNames().stream()
                .forEach(n -> System.out.println(n + " : " + ladderGameResult.getPlayerResult(n)));
    }
}
