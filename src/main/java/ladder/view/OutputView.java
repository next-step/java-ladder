package ladder.view;

import ladder.*;

public class OutputView {

    public static void printResult(Players players, Ladder ladder, Results results) {
        System.out.println("\n사다리 결과\n");
        printNames(players);
        printLadder(ladder);
        printResults(results);
    }

    private static void printResults(Results results) {
        results.getResults().forEach(result ->
                System.out.printf("%-6s", result));
        System.out.println();
    }

    private static void printNames(Players players) {
        players.players().forEach(player ->
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

    public static void printSingleResult(Player player, LadderResults results) {
        Result result = results.getResultOf(player);
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
            Result result = results.getResultOf(player);
            System.out.println(player + " : " + result.toString());
        });
    }
}
