package ladder.io;


import ladder.domain.LadderResult;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.Line;
import ladder.domain.engine.Rewards;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static ladder.domain.PlayerName.NAME_WIDTH;

public class ConsoleOutputHandler implements OutputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String BAR = "|";
    public static final String DASH = "-";
    public static final String SPACE = " ";
    public static final String ALL = "all";

    public void showLadderGameResult(Players players, Ladder ladder, Rewards ladderResults) {
        printResultTitle();

        printPlayers(players);

        printLadder(ladder);

        printExecutionResults(ladderResults);
    }

    private void printResultTitle() {
        System.out.println("사다리 결과");
        printBlankLine();
    }

    private void printPlayers(Players players) {
        for (Player player : players.players()) {
            System.out.printf("%-7s", player.playerName());
        }
        printBlankLine();
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(SPACE.repeat(4));
        for (Boolean point : line.points()) {
            System.out.print(BAR);
            drawBridge(point);
        }
        System.out.println(BAR);
    }

    private void drawBridge(boolean point) {
        if (point) {
            System.out.print(DASH.repeat(NAME_WIDTH));
            return;
        }
        System.out.print(SPACE.repeat(NAME_WIDTH));
    }

    private void printExecutionResults(Rewards rewards) {
        List<String> results = rewards.getRewards();
        for (String result : results) {
            System.out.printf("%-6s", result);
        }
        printBlankLine();
    }

    @Override
    public void showCommentForWhoseResultWantToSee() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    @Override
    public void showAllResults(LadderResult ladderResult) {
        Map<String, String> ladderGameOutcomes = ladderResult.getLadderResult();
        showTextOfFinalResult();
        for (Map.Entry<String, String> entry : ladderGameOutcomes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public void showResultForPlayer(String nameOfPlayer, LadderResult ladderResult) {
        Map<String, String> ladderGameOutcomes = ladderResult.getLadderResult();
        showTextOfFinalResult();
        System.out.println(ladderGameOutcomes.get(nameOfPlayer));
        printBlankLine();
    }

    @Override
    public void printResult(LadderResult result) {
        while (processResultRequest(result)) {
        }
    }

    private boolean processResultRequest(LadderResult result) {
        showCommentForWhoseResultWantToSee();
        String playerName = getPlayerNameForResultFromUser();
        if (isRequestForAllResults(playerName)) {
            showAllResults(result);
            return false;
        }
        showResultForPlayer(playerName, result);
        return true;
    }

    public String getPlayerNameForResultFromUser() {
        return SCANNER.nextLine();
    }

    private boolean isRequestForAllResults(String playerName) {
        return playerName.equals(ALL);
    }

    private void showTextOfFinalResult() {
        printBlankLine();
        System.out.println("실행 결과");
    }

    private void printBlankLine() {
        System.out.println();
    }

}
