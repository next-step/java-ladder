package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import ladder.domain.impl.MyLadder;
import ladder.domain.impl.MyLine;
import ladder.domain.impl.Tile;
import ladder.domain.impl.TileType;
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
     * Methods to print names and prizes∂
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

    public static void printLadder(MyLadder ladder, int maxLength) {
        System.out.println(ladderToString(ladder, maxLength));
    }

    private static String ladderToString(MyLadder ladder, int maxLength) {
        List<String> lineStrings = ladder.getLines()
                .stream()
                .map(line -> lineToString((MyLine) line, maxLength))
                .collect(Collectors.toList());
        return String.join(NEWLINE, lineStrings);
    }

    private static String lineToString(MyLine line, int width) {
        List<String> legs = line.getTiles()
                .stream()
                .map(tile -> tileToString(tile, width))
                .collect(Collectors.toList());
        return StringUtils.repeat(" ", width) + VERTICAL + String.join(VERTICAL, legs);
    }

    private static String tileToString(Tile tile, int width) {
        if (tile.getTileType() == TileType.RIGHT) {
            return StringUtils.repeat("-", width);
        }
        return StringUtils.repeat(" ", width);
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

    public static void printHeader() {
        System.out.println(RESULT_HEADER);
    }

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
