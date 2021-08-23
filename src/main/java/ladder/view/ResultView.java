package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.line.Line;
import ladder.domain.ladder.point.Point;
import ladder.domain.player.PlayerName;
import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrize;
import ladder.domain.prize.LadderPrizes;
import ladder.utils.StringUtils;

public class ResultView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String RESULT_HEADER = NEWLINE + "사다리 결과" + NEWLINE;
    public static final String EXECUTION_HEADER = NEWLINE + "실행 결과";
    public static final String VERTICAL = "|";
    public static final String HORIZONTAL = "-";
    public static final String SPACE = " ";
    public static final int PADDING = 1;

    private ResultView() {
    }

    /*
     * Methods to print names and prizes
     */

    public static void printPlayerNames(PlayerNames playerNames, int maxLength) {
        int width = maxLength + PADDING;
        List<String> names = playerNames.getNames()
                .stream()
                .map(playerName -> spaceString(playerName.getName(), width))
                .collect(Collectors.toList());
        System.out.println(String.join("", names));
    }

    public static void printLadderPrizes(LadderPrizes ladderPrizes, int maxLength) {
        int width = maxLength + PADDING;
        List<String> prizes = ladderPrizes.getPrizes()
                .stream()
                .map(ladderPrize -> spaceString(ladderPrize.getPrize(), width))
                .collect(Collectors.toList());
        System.out.println(String.join("", prizes));
    }

    /*
     * Methods to print ladder to screen
     */

    public static void printLadder(Ladder ladder, int width) {
        List<String> lines = ladder.getLines()
                .stream()
                .map(line -> lineToString(line, width))
                .collect(Collectors.toList());
        System.out.println(String.join(NEWLINE, lines));
    }

    private static String lineToString(Line line, int width) {
        List<String> points = line.getPoints()
                .stream()
                .map(point -> pointToString(point, width))
                .collect(Collectors.toList());
        return String.join(VERTICAL, points) + VERTICAL;
    }

    private static String pointToString(Point point, int width) {
        if (point.getLeg().isLeft()) {
            return StringUtils.repeat(HORIZONTAL, width);
        }
        return StringUtils.repeat(SPACE, width);
    }

    /*
     * Methods to print ladder execution results
     */

    public static void printAllResults(Map<String, String> nameToPrize) {
        for (Map.Entry<String, String> entry : nameToPrize.entrySet()) {
            String name = entry.getKey();
            String prize = entry.getValue();
            System.out.println(name + " : " + prize);
        }
    }

    public static void printResultByName(String name, Map<String, String> nameToPrize) {
        String prize = nameToPrize.get(name);
        System.out.println(EXECUTION_HEADER);
        System.out.println(prize);
    }

    /*
     * Helper methods
     */

    public static int findMaxLength(PlayerNames playerNames, LadderPrizes ladderPrizes) {
        List<String> names = playerNames.getNames()
                .stream()
                .map(PlayerName::getName)
                .collect(Collectors.toList());
        List<String> prizes = ladderPrizes.getPrizes()
                .stream()
                .map(LadderPrize::getPrize)
                .collect(Collectors.toList());
        return Math.max(findMaxLength(names), findMaxLength(prizes));
    }

    private static int findMaxLength(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private static String spaceString(String string, int width) {
        String template = String.format("%%%ds", width);
        return String.format(template, string);
    }
}
