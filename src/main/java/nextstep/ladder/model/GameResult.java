package nextstep.ladder.model;

import nextstep.ladder.view.ResultFormatter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private List<Integer> positions;
    private Players players;

    public GameResult(Players players, Ladder ladder) {
        this.players = players;
        this.positions = resultLadder(ladder, players.countOfPlayer());
    }

    private List<Integer> resultLadder(Ladder ladder, int countOfPerson) {
        List<Integer> result = IntStream.range(0, countOfPerson)
                .map(n -> ladder.moveToResult(n))
                .boxed()
                .collect(Collectors.toList());
        return result;
    }

    protected int getOnePosition(int firstPoint) {
        return positions.get(firstPoint);
    }

    public String getFormattedResult() {
        ResultFormatter resultFormatter = new ResultFormatter();
        return resultFormatter.format(this);
    }

    public String getPrize(String playerName) {
        int playerPosition = players.getPosition(playerName);
        int resultPosition = getOnePosition(playerPosition);
        return players.getPrize(resultPosition);
    }

    public String getPrize(int position) {
        int resultPosition = getOnePosition(position);
        return players.getPrize(resultPosition);
    }

    public Players getPlayers() {
        return players;
    }
}
