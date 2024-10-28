package ladder.io;


import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.LadderResults;

import java.util.List;
import java.util.Map;

import static ladder.domain.PlayerName.NAME_WIDTH;

public class ConsoleOutputHandler implements OutputHandler {

    public static final String BAR = "|";
    public static final String DASH = "-";
    public static final String SPACE = " ";

    @Override
    public void showCommentForNamesOfPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    @Override
    public void showCommentForPlayResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    @Override
    public void showCommentForHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    @Override
    public void showLadderGameResult(Players players, Ladder ladder, LadderResults ladderResults) {
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
        for (Player player : players.getPlayers()) {
            System.out.printf("%-7s", player.getPlayerName());
        }
        printBlankLine();
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(SPACE.repeat(4));
        for (Boolean point : line.getPoints()) {
            System.out.print(BAR);
            drawBridge(point);
        }
        System.out.println(BAR);
    }

    private void drawBridge(Boolean point) {
        if (point) {
            System.out.print(DASH.repeat(NAME_WIDTH));
            return;
        }
        System.out.print(SPACE.repeat(NAME_WIDTH));
    }

    private void printExecutionResults(LadderResults ladderResults) {
        List<String> executionResults = ladderResults.getExecutionResults();
        for (String result : executionResults) {
            System.out.printf("%-6s", result);
        }
        printBlankLine();
    }

    @Override
    public void showCommentForWhoseResultWantToSee() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    @Override
    public void showAllResults(LadderResults ladderResults) {
        Map<String, String> ladderGameOutcomes = ladderResults.getLadderGameOutcomes();
        showTextOfFinalResult();
        for (Map.Entry<String, String> entry : ladderGameOutcomes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public void showResultForPlayer(String nameOfPlayer, LadderResults ladderResults) {
        Map<String, String> ladderGameOutcomes = ladderResults.getLadderGameOutcomes();
        showTextOfFinalResult();
        System.out.println(ladderGameOutcomes.get(nameOfPlayer));
        printBlankLine();
    }

    private void showTextOfFinalResult() {
        printBlankLine();
        System.out.println("실행 결과");
    }

    private void printBlankLine() {
        System.out.println();
    }

}
