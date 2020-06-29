package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Players;
import domain.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int TO_BE_REMOVED_LAST_POINT = 1;
    private static final String DEFAULT_NAME = "     ";
    private static final int MAX_SPACE_SIZE = 5;

    public static final String LINE = "|";
    public static final String CONNECT = "-----";
    public static final String NOT_CONNECT = "     ";
    public static final String FIRST_SPACE = " ";

    public static void printResult(Players players, Ladder ladder, String[] results) {
        System.out.println("사다리 결과");

        System.out.println(get5SpaceTexts(players.getPlayerNames()));

        System.out.println(ladder.getLines().stream()
                .map(line -> getLineText(line.getPoints()))
                .collect(Collectors.joining("\n")));

        System.out.println(get5SpaceTexts(results));
    }

    public static String getLineText(List<Point> points) {
        return FIRST_SPACE.concat(LINE)
                .concat(points.stream()
                        .limit(points.size() - TO_BE_REMOVED_LAST_POINT)
                        .map(point -> point.isNextConnect() ? CONNECT : NOT_CONNECT)
                        .collect(Collectors.joining(LINE)))
                .concat(LINE);
    }

    public static String get5SpaceTexts(String[] text) {
        return Arrays.stream(text)
                .map(OutputView::get5SpaceText)
                .collect(Collectors.joining(" "));
    }

    public static String get5SpaceText(String text) {
        int beforeBlank = (MAX_SPACE_SIZE - text.length()) / 2;
        int afterBlank = MAX_SPACE_SIZE - beforeBlank - text.length();

        return DEFAULT_NAME.substring(0, beforeBlank) + text + DEFAULT_NAME.substring(0, afterBlank);
    }

    public static void printWhoResult(String who, LadderResult ladderResult) {
        System.out.println("실행결과");

        System.out.println(ladderResult.getResult(who));
    }
}
