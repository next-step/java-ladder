package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String BRIDGE = "-----";
    private static final String PASS = "     ";
    private static final String COLUMN = "|";

    private static final String PLAYER_NAME_PRINT_FORM = "%6s";

    private static final String RESULT_MESSAGE = "실행결과";

    public static void resultMessagePrint() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println();
    }
    public static void printName(List<Person> persons) {
        String result = persons.stream()
                .map(Person::getName)
                .map(ResultView::playerNameOutputFormat)
                .collect(Collectors.joining(""));
        System.out.println(result);
    }

    private static String playerNameOutputFormat(String playerName) {
        return String.format(PLAYER_NAME_PRINT_FORM, playerName);
    }

    public static void resultLadders(Ladder ladder) {
        ladder.getLines()
                .forEach(ResultView::resultLadder);
    }

    private static void resultLadder(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.getPoints()
                .forEach(value -> stringBuilder.append(divideValue(value)).append(COLUMN));
        System.out.println(stringBuilder);
    }

    private static String divideValue(boolean value) {
        if (value) {
            return BRIDGE;
        }
        return PASS;
    }
}
