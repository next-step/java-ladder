package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String INTERVAL = "  ";
    private static final String BRIDGE = "-----";
    private static final String PASS = "     ";
    private static final String COLUMN = "|";
    private static final String ENTER = "\n";

    private ResultView() {
    }

    public static void printName(List<Person> persons) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = persons.stream()
                .map(Person::getName)
                .map(Name::getName)
                .collect(Collectors.joining(INTERVAL));
        stringBuilder.append(String.format("%s실행결과%s%s %s", ENTER, ENTER, ENTER, result));
        System.out.println(stringBuilder);
    }

    public static void resultLadders(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        ladder.getLines().stream()
                .forEachOrdered(line -> resultLadder(stringBuilder, line));
        System.out.println(stringBuilder);
    }

    private static void resultLadder(StringBuilder stringBuilder, Line line) {
        stringBuilder.append(INTERVAL);
        stringBuilder.append(COLUMN);
        line.getPoints().stream()
                .forEachOrdered(value -> stringBuilder.append(divideValue(value)).append(COLUMN));
        stringBuilder.delete(stringBuilder.length() - 6, stringBuilder.length());
        stringBuilder.append(ENTER);
    }

    private static String divideValue(boolean value) {
        if (value) {
            return BRIDGE;
        }
        return PASS;
    }

}
