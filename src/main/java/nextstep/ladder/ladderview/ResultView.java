package nextstep.ladder.ladderview;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderGameResult;

public class ResultView {

    public void printResult(List<String> players, String ladders, List<String> results) {
        printReultGuide();
        printPlayers(players);
        printLadders(ladders);
        printResults(results);
    }

    private void printReultGuide() {
        System.out.println("\n사다리 결과\n");
    }

    private void printPlayers(List<String> players) {
        players.stream()
                .forEach(i -> printByFormat(i));
        System.out.println();
    }

    private void printResults(List<String> players) {
        players.stream()
                .forEach(i -> printByFormat(i));
        System.out.println();
    }

    private void printByFormat(String input) {
        System.out.print(String.format("%6s", input));
    }

    private void printLadders(String ladders) {
        System.out.print(ladders);
    }

    public void printResultOfPlayer(LadderGameResult ladderGameResult, String player) {
        System.out.println("\n실행 결과");
        if (player.equals("all")) {
            printAllExecutionResult(ladderGameResult);
            return;
        }
        printExecutionResult(ladderGameResult, player);
    }

    private void printAllExecutionResult(LadderGameResult ladderGameResult) {
        System.out.println(ladderGameResult.getAllResultOfPlayer()
                .entrySet()
                .stream()
                .map(player -> player.getKey() + " : " + player.getValue() + "\n")
                .collect(Collectors.joining()));
    }

    private void printExecutionResult(LadderGameResult ladderGameResult, String player) {
        System.out.println(ladderGameResult.getSpecificPlayerResult(player));
    }
}
