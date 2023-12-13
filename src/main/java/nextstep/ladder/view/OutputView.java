package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.concrete.Brace;
import nextstep.ladder.domain.concrete.Ladder;
import nextstep.ladder.domain.concrete.Line;

public class OutputView {
    private static final String ALL_PLAYERS = "all";
    private static final StringBuilder sb = new StringBuilder();

    public static void printLadder(Players players, Ladder ladder, Amounts amounts) {
        sb.setLength(0);

        appendPersonNames(players);
        appendLadder(ladder);
        appendResultAmounts(amounts);

        System.out.println(sb);
    }

    private static void appendPersonNames(Players players) {
        for (Player player : players) {
            sb.append(String.format("%5s", player));
        }
        sb.append("\n");
    }

    private static void appendLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            sb.append("  |");
            appendBrace(line);
            sb.setLength(sb.length() - 6);
            sb.append("\n");
        }
    }

    private static void appendBrace(Line line) {
        for (Brace brace : line.braces()) {
            addBrace(brace);
        }
    }

    private static void addBrace(Brace brace) {
        if (brace.isRight()) {
            sb.append("-----");
            sb.append("|");
        }

        if (!brace.isRight()) {
            sb.append("     ");
            sb.append("|");
        }
    }

    private static void appendResultAmounts(Amounts amounts) {
        for (Amount amount : amounts) {
            sb.append(String.format("%5s", amount));
        }
        sb.append("\n");
    }

    public static void printResultLoop(LadderGameResult ladderGameResult) {
        String inputName = "";
        while (!inputName.equals(ALL_PLAYERS)) {
            inputName = InputView.inputPlayer();

            System.out.println("실행 결과");
            printPlayerResults(ladderGameResult, inputName);
        }
    }

    private static void printPlayerResults(LadderGameResult ladderGameResult, String inputName) {
        if (inputName.equals(ALL_PLAYERS)) {
            printAllPlayersResults(ladderGameResult);
            return;
        }
        printPlayerResult(ladderGameResult, inputName);
    }

    private static void printAllPlayersResults(LadderGameResult ladderGameResult) {
        for (Player player : ladderGameResult.keySet()) {
            System.out.printf("%s : %s\n", player, ladderGameResult.get(player));
        }
    }

    private static void printPlayerResult(LadderGameResult ladderGameResult, String inputName) {
        System.out.printf("%s : %s\n", inputName, ladderGameResult.get(new Player(inputName)));
    }
}
