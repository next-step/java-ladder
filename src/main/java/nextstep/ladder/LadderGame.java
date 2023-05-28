package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class LadderGame {

    private static final String ALL_PLAYER = "all";

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.run();
    }

    public void run() {

        Map<PlayerName, Player> players = addPlayers(InputView.inputPlayers());
        Map<ResultId, Result> results = addResults(InputView.inputResult());

        Ladder ladder = new Ladder(InputView.inputLadderHeight(), players.size());

        ResultView.printLadderResult(players, ladder.getLines(), results);

        players = getPlayerResult(players, results, ladder);


        printPlayerResult(players);

    }

    private Map<PlayerName, Player> addPlayers(String inputPlayers) {
        AtomicInteger index = new AtomicInteger(0);
        return Arrays.stream(inputPlayers.split(","))
                .map(name -> new Player(new PlayerName(name), index.getAndIncrement()))
                .collect(Collectors.toMap(Player::getName, player -> player, (x, y) -> y, LinkedHashMap::new));
    }

    private Map<ResultId, Result> addResults(String inputResults) {
        AtomicLong index = new AtomicLong(0);
        return Arrays.stream(inputResults.split(","))
                .map(value -> new Result(new ResultId(index.getAndIncrement()), value))
                .collect(Collectors.toMap(Result::getId, result -> result));
    }

    private Map<PlayerName, Player> getPlayerResult(Map<PlayerName, Player> players, Map<ResultId, Result> results, Ladder ladder) {
        Map<PlayerName, Player> newResults = new LinkedHashMap<>();
        for (PlayerName playerName : players.keySet()) {
            Player player = players.get(playerName);
            player.saveResult(results.get(calculateResultId(players.get(player.getName()), ladder)));
            newResults.put(playerName, player);
        }
        return newResults;
    }

    private ResultId calculateResultId(Player player, Ladder ladder) {
        int playerPosition = player.getStartPosition();
        for (Line line : ladder.getLines()) {
            playerPosition = calculatePosition(line.getPoints(), playerPosition);
        }
        return new ResultId((long) playerPosition);
    }

    private int calculatePosition(List<Point> points, int playerPosition) {
        if (points.get(playerPosition).getStatus().hasRight()) {
            return playerPosition + 1;
        }
        if (points.get(playerPosition).getStatus().hasLeft()) {
            return playerPosition - 1;
        }
        return playerPosition;
    }

    private void printPlayerResult(Map<PlayerName, Player> players) {

        String inputPlayer = "";

        while (!ALL_PLAYER.equals(inputPlayer)) {

            inputPlayer = InputView.inputPlayer();

            ResultView.printPlayerResult(inputPlayer, players);

        }
    }

}
