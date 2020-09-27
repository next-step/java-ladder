package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    private static final String PRINT_INTERVAL = "%6s";

    public static void printLadder(Ladder ladder, Players players, LadderResults results) {
        System.out.println("실행 결과");
        printNames(players.getPlayers());
        printLadder(ladder);
        printResults(results);
    }

    private static void printNames(List<Player> players) {
        players.stream()
                .map(Player::toString)
                .forEach(ResultView::printByFormat);
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (Pipes pipes : ladder.convertToPipes()) {
            printByFormat("|");
            printPipes(pipes.getPipes());
            System.out.println();
        }
    }

    private static void printPipes(List<Pipe> pipes) {
        pipes.stream()
                .map(Pipe::getPipe)
                .forEach(ResultView::printByFormat);
    }

    private static void printResults(LadderResults results) {
        results.getResults()
                .forEach(ResultView::printByFormat);
    }

    public static void printResultOfPlayer(int laneIndex, LadderResults results) {

    }

    private static void printByFormat(String value) {
        System.out.printf(PRINT_INTERVAL, value);
    }
}
