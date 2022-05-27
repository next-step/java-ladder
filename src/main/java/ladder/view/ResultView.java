package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LADDER_INTERVAL = "  ";
    private static final String RESULT_INTERVAL = "   ";
    private static final String BRIDGE = "-----";
    private static final String PASS = "     ";
    private static final String COLUMN = "|";
    private static final String ENTER = "\n";
    private static final String ALL = "all";

    private ResultView() {
    }

    public static void printName(List<Person> persons) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = persons.stream()
                .map(Person::getName)
                .map(Name::getName)
                .collect(Collectors.joining(LADDER_INTERVAL));
        stringBuilder.append(String.format("%s실행결과%s%s %s", ENTER, ENTER, ENTER, result));
        System.out.println(stringBuilder);
    }

    public static void drawLadders(Ladder ladder, List<String> results) {
        StringBuilder stringBuilder = new StringBuilder();
        ladder.getLines().stream()
                .forEachOrdered(line -> drawLadder(stringBuilder, line));

        String result = results.stream()
                .collect(Collectors.joining(RESULT_INTERVAL));
        stringBuilder.append(String.format("  %s%s ", result, ENTER));
        System.out.println(stringBuilder);
    }

    public static void drawLadder(StringBuilder stringBuilder, Line line) {
        stringBuilder.append(LADDER_INTERVAL);
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

    public static void resultFinal(LadderResult ladderResult, String request) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> temporary = ladderResult.getLadderResult();
        
        stringBuilder.append(String.format("%s%s%s", ENTER, "실행결과", ENTER));
        if (request.equals(ALL)) {
            temporary.keySet().stream()
                    .forEachOrdered(key -> stringBuilder.append(String.format("%s : %s %s", key, temporary.get(key), ENTER)));
            System.out.println(stringBuilder);
            return;
        }
        stringBuilder.append(temporary.get(request));
        System.out.print(stringBuilder);
    }
}
