package ladder.view;

import ladder.*;

public class OutputView {

    public static void printResult(LadderResults results, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        printNames(results);
        printLadder(ladder);
        printResults(results);
    }

    private static void printResults(LadderResults results) {
        results.getPlayers().forEach(player ->
                System.out.printf("%-6s", results.getResultMap().get(player).toString()));
        System.out.println();
    }

    private static void printNames(LadderResults results) {
        results.getPlayers().forEach(player ->
                System.out.printf("%-6s", player));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            StringBuilder row = new StringBuilder();
            for (Point point : line.points()) {
                row.append("|");
                row.append(point.hasRight() ? "-----" : "     ");
            }
            row.append("|");
            System.out.println(row);
        }
    }

    public static void printSingleResult(String name, LadderResults results) {
        Result result = results.getResultOf(name);
        if (result == null) {
            System.out.println("존재하지 않는 참가자입니다.");
            return;
        }
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public static void printAllResults(LadderResults results) {
        System.out.println("\n실행 결과");
        results.getPlayers().forEach(player -> {
            Result result = results.getResultMap().get(player);
            System.out.println(player + " : " + result.toString());
        });
    }
}
