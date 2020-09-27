package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    private static final String PRINT_INTERVAL = "%6s";

    private final Players players;
    private final LadderResults results;

    public ResultView(Players players, LadderResults results) {
        this.players = players;
        this.results = results;
    }

    public void printLadder(Ladder ladder) {
        System.out.println("사다리 결과");
        printNames(players.getPlayers());
        printPipes(ladder);
        printResults();
    }

    private void printNames(List<Player> players) {
        players.stream()
                .map(Player::toString)
                .forEach(this::printByFormat);
        System.out.println();
    }

    private void printPipes(Ladder ladder) {
        for (Pipes pipes : ladder.convertToPipes()) {
            printByFormat("|");
            printLine(pipes.getPipes());
            System.out.println();
        }
    }

    private void printLine(List<Pipe> pipes) {
        pipes.stream()
                .map(Pipe::getPipe)
                .forEach(this::printByFormat);
    }

    private void printResults() {
        results.getResults()
                .forEach(this::printByFormat);
        System.out.println();
    }

    public void printResultOfPlayer(String name) {
        System.out.println(results.getResultByLane(players.find(name).getLane()));
    }

    public void printResultsOfAll() {
        players.getPlayers()
                .forEach(player ->
                        System.out.printf("%s : %s\n", player, results.getResultByLane(player.getLane()))
                );
    }

    private void printByFormat(String value) {
        System.out.printf(PRINT_INTERVAL, value);
    }
}
