package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void printResult(List<String> result, int countOfPerson) {
        System.out.println("실행결과");
        result.stream()
                .map(line -> drawLadderByLine(line, countOfPerson))
                .forEach(System.out::println);
    }

    public static String drawLadderByLine(String mapLine, int countOfPerson) {
        List<String> tokens = Arrays.asList(mapLine.split(","));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countOfPerson - 1; i++) {
            stringBuilder.append("|");
            stringBuilder.append(drawBridge(tokens, i));
        }
        stringBuilder.append("|");

        return stringBuilder.toString();
    }

    private static String drawBridge(List<String> tokens, int index) {
        if (tokens.contains(String.valueOf(index))) {
            return "-----";
        }
        return "     ";
    }
}
