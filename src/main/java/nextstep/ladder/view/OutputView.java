package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {

    private static final String BLANK = "     ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String TAB = "\t";

    public static void outputLadderResult(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과\n");

        outputPerson(players);
        outputLadder(ladder);
        outputResults(results);
    }
    private static void outputPerson(Players person) {
        person.getPlayers()
                .forEach(p -> System.out.print(p + TAB));

        System.out.println();
    }

    private static void outputLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            outputLines(line);
        }
    }

    private static void outputResults(Results results) {
        results.getResults()
                .forEach(r -> System.out.print(r + TAB));
    }

    private static void outputLines(Line line) {
        for (Point point : line.getPoints()) {
            System.out.print(VERTICAL_LINE);
            System.out.print(getLine(point.isPoint()));
        }
        System.out.println(VERTICAL_LINE);
    }

    private static String getLine(boolean isBoolean) {
        if (isBoolean) {
            return HORIZONTAL_LINE;
        }
        return BLANK;

    }

    public static void outputResult(Players players, Results results, String player) {
        if (player.equals("all")) {
            outputAllResult(players, results);
            return;
        }

        outputOneResult(results.getResult(players.getIndex(player)));
    }

    private static void outputAllResult(Players players, Results results) {
        System.out.println("실행 결과");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.getPlayer(i) + " : " + results.getResult(i));
        }
    }

    public static void outputOneResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
