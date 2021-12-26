package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final  String LADDER_RUN_MESSAGE = "사다리 결과\n";
    private static final String GAME_RUN_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%6s";
    private static final String LADDER_BLANK = "     ";
    private static final String LADDER_DASH = "-----";
    private static final String LADDER_LINE = "|";

    private ResultView() {}

    public static void gameResult(Names names, Ladder ladder) {
        System.out.println(LADDER_RUN_MESSAGE);
        System.out.println(printEntryName(names));
        printLaddersResult(ladder);
    }

    public static void printItems(Items items) {
        System.out.println( items.getItems()
                .stream()
                .map(item -> String.format(NAME_FORMAT, item.getValue()))
                .collect(Collectors.joining()));
    }

    public static void printPlayerResult(Items items, int index) {
        System.out.print(GAME_RUN_MESSAGE);
        System.out.println(items.getItems().get(index).getValue());
    }

    public static void printGameAllPlayerResult(GameResult gameResult, Items items) {
        System.out.print(GAME_RUN_MESSAGE);
        Map<Name, Integer> result = gameResult.getGameResult();
        result.forEach((name, index) -> System.out.printf("%s : %s\n", name.getValue(), items.getItems().get(index).getValue()));
    }

    private static String printEntryName(Names names) {
        return names.getNames()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name.getValue()))
                .collect(Collectors.joining());
    }

    private static void printLaddersResult(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
            System.out.printf("%s%s", LADDER_BLANK, LADDER_LINE);
                    IntStream.range(0, line.getLine().size() - 1)
                            .forEach(index -> printPoint(line.getLine().get(index)));
                    System.out.println();
                });
    }

    private static void printPoint(Point point) {
        if (point.rightLineExists()) {
            System.out.printf("%s%s", LADDER_DASH, LADDER_LINE);
            return;
        }
        System.out.printf("%s%s", LADDER_BLANK, LADDER_LINE);
    }
}
