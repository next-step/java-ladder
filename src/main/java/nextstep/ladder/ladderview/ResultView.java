package nextstep.ladder.ladderview;

import java.util.List;

public class ResultView {

    public void printResult(List<String> players, String ladders, List<String> results) {
        printReultGuide();
        printPlayers(players);
        printLadders(ladders);
        printResults(results);
    }

    private void printReultGuide() {
        System.out.println("\n실행 결과\n");
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
}
