package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private final static String LADDER_RUN_MESSAGE = "사다리 결과\n";
    private final static String GAME_RUN_MESSAGE = "실행결과\n";
    private final static String NAME_FORMAT = "%6s";
    private final static String LADDER_BLANK = "     ";
    private final static String LADDER_DASH = "-----";
    private final static String LADDER_LINE = "|";

    public void gameResult(Names names, Ladder ladder) {
        System.out.println(LADDER_RUN_MESSAGE);
        System.out.println(printEntryName(names));
        printLaddersResult(ladder);
    }

    public void printItems(Items items) {
        System.out.println( items.getItems()
                .stream()
                .map(item -> String.format(NAME_FORMAT, item.getValue()))
                .collect(Collectors.joining()));
    }

    private String printEntryName(Names names) {
        return names.getNames()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name.getValue()))
                .collect(Collectors.joining());
    }

    private void printLaddersResult(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
                    IntStream.range(0, line.getLine().size() - 1)
                            .forEach(index -> printPoint(line.getLine().get(index)));
                    System.out.println();
                });
    }

    private void printPoint(Point point) {
        if (point.isValue()) {
            System.out.printf("%s%s", LADDER_DASH, LADDER_LINE);
            return;
        }
        System.out.printf("%s%s", LADDER_BLANK, LADDER_LINE);
    }

    public void printPlayerResult(Items items, int index) {
        System.out.print(GAME_RUN_MESSAGE);
        System.out.println(items.getItems().get(index).getValue());
    }

    public void printGameAllPlayerResult(GameResult gameResult, Items items) {
        System.out.print(GAME_RUN_MESSAGE);
        Map<Name, Integer> result = gameResult.getGameResult();
        result.forEach((name, index) -> System.out.printf("%s : %s\n", name.getValue(), items.getItems().get(index).getValue()));
    }
}
