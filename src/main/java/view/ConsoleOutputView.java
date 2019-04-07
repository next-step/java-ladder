package view;

import domain.Ladder;
import domain.Position;

import java.util.List;

public class ConsoleOutputView {
    public static void printPositions(List<Position> positions) {
        positions.forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printAllResult(List<Position> users, List<Position> results, Ladder ladder) {
        for (Position user : users) {
            System.out.print(user.getName() + " : ");

            Position result = results.get(ladder.search(user.getLocation()) - 1);
            System.out.println(result.getName());
        }
    }

    public static void printOneResult(String name, List<Position> users, List<Position> results, Ladder ladder) {
        Position user = users.stream().filter(p -> p.getName().equals(name)).findFirst().get();

        Position result = results.get(ladder.search(user.getLocation()) - 1);
        System.out.println(result.getName());
    }
}
