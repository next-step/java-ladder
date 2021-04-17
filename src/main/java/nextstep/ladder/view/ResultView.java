package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void printLadderResult(List<String> result, int countOfPerson) {
        result.stream()
                .map(line -> drawLadderByLine(line, countOfPerson))
                .forEach(System.out::println);
    }

    public static String drawLadderByLine(String mapLine, int countOfPerson) {
        List<String> tokens = Arrays.asList(mapLine.split(","));
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("     ");
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

    public static void printResultList(List<String> result) {
        System.out.println("실행 결과");
        result.stream()
                .forEach(System.out::println);
    }

    public static void printObjectsName(List<String> names) {
        names.stream()
                .map(ResultView::paddingName)
                .forEach(System.out::print);
        System.out.printf("%n");
    }

    private static String paddingName(String name) {
        if (name.length() == 5) {
            return " " + name;
        }
        int paddingCount = 5 - name.length();
        String padding = " ";

        for (int i = 0; i < paddingCount; i++) {
            padding += " ";
        }
        return padding + name;
    }
}
