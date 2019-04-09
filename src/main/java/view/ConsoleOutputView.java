package view;

import domain.Ladder;
import domain.Position;

import java.util.List;
import java.util.Map;

public class ConsoleOutputView {
    public static void printPositions(List<Position> positions) {
        positions.forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printAllResult(Map<String, String> totalResult) {
        totalResult.keySet()
            .forEach(s -> printOneResult(s, totalResult.get(s)));
    }

    public static void printOneResult(String name, String result) {
        System.out.println(name + " : " + result);
    }
}
