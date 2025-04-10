package view;

import domain.Ladder;
import domain.LadderGameEngine;
import domain.Line;
import domain.PlayerName;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

//    public static void printLine(Ladder ladder) {
//        ladder.printline();
//    }

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + System.lineSeparator(), output);
    }

    public static void printNames(List<PlayerName> names) {
        names.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

    public static void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        for (boolean point : line.getPoints()) {
            builder.append("|");
            builder.append(point ? "-----" : "     ");
        }
        builder.append("|");
        System.out.println(builder);
    }

    public static void printLine(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    public static void printResults(List<String> results) {
        results.forEach(r -> System.out.printf("%-6s", r));
        System.out.println();
    }

    public static void printSingleResult(PlayerName player, List<PlayerName> players, Ladder ladder, ResultMapping mapping) {
        System.out.println("실행 결과");

        int startIndex = players.indexOf(player);
        int resultIndex = LadderGameEngine.move(ladder, startIndex);

        PlayerName resultPlayer = players.get(resultIndex);
        String result = mapping.getResult(resultPlayer);

        System.out.println(result);
    }

    public static void printAllResults(List<PlayerName> players, Ladder ladder, ResultMapping mapping) {
        System.out.println("실행 결과");

        for (PlayerName player : players) {
            int startIndex = players.indexOf(player);
            int resultIndex = LadderGameEngine.move(ladder, startIndex);

            PlayerName resultPlayer = players.get(resultIndex);
            String result = mapping.getResult(resultPlayer);

            System.out.println(player.getName() + " : " + result);
        }
    }

}
