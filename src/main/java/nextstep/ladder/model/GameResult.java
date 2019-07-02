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

    public List<Integer> resultLadder(Ladder ladder, int countOfPerson) {
        List<Integer> result = makeCurrentPoints(countOfPerson);
        for (Line line : ladder.getLines()) {
            result = line.lineResult(result);
        }
        return result;
    }

    public int getOnePosition(int firstPoint) {
        return positions.get(firstPoint);
    }

    private List<Integer> makeCurrentPoints(int countOfPerson) {
        return IntStream.range(0, countOfPerson)
                .boxed()
                .collect(Collectors.toList());
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

    public String getFormattedResult() {
        ResultFormatter resultFormatter = new ResultFormatter();
        return resultFormatter.format(this);
    }

    public Players getPlayers() {
        return players;
    }
}
