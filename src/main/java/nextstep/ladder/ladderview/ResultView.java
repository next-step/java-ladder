package nextstep.ladder.ladderview;

import java.util.List;

public class ResultView {

    public void printResult(List<String> players, String ladders) {
        printReultGuide();
        printPlayers(players);
        printLadders(ladders);
    }

    private void printReultGuide() {
        System.out.println("\n실행 결과\n");
    }

    private void printPlayers(List<String> players) {
        players.stream()
                .forEach(i -> printPlayerFormat(i));
        System.out.println();
    }

    private void printPlayerFormat(String name) {
        System.out.print(String.format("%6s", name));
    }

    private void printLadders(String ladders) {
        System.out.println(ladders);
    }
}
