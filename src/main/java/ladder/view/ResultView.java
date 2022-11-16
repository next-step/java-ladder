package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Point;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void PrintResult(List<Name> names, Ladder ladder, int height, List<String> results) {
        printNames(names);
        printLadder(ladder, names.size(), height);
        printResults(results);
    }

    private static void printNames(List<Name> names) {
        String nameString = names.stream()
                .map(name -> String.format("%5s", name.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(nameString);
    }

    private static void printLadder(Ladder ladder, int peopleCount, int height) {
        for (int i = 0; i < height; i++) {
            printHorizontalLine(ladder, peopleCount, i);
        }
    }

    private static void printResults(List<String> results) {
        String resultsString = results.stream()
                .map(result -> String.format("%5.5s", result))
                .collect(Collectors.joining(" "));
        System.out.println(resultsString);
    }

    private static void printHorizontalLine(Ladder ladder, int peopleCount, int horizontalIndex) {
        for (int j = 0; j < peopleCount; j++) {
            Point point = ladder.getLine(j).getPoint(horizontalIndex);
            printPoint(point);
        }
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point == Point.LEFT) {
            System.out.print("-----|");
            return;
        }

        System.out.print("     |");
    }

    public static void printPersonResult(String result) {
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResult(Map<Name, String> results) {
        for (Map.Entry<Name, String> entry: results.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
        System.out.println();
    }
}
