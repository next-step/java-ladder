package ladder.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ladder.result.Award;
import ladder.result.Awards;
import ladder.result.LadderResult;
import ladder.user.Player;
import ladder.user.Players;

public class Ladder {

    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getLadderLines() {
        return rows;
    }

    public LadderResult play(Players players, Awards awards) {
        Map<Player, Award> result = new HashMap<>();

        for (int index = 0; index < players.size(); index++) {
            Position destination = descending(index);
            result.put(new Player(players.getPlayers().get(index).getUserName(), new Position(index)), awards.getAward(destination));
        }
        return new LadderResult(result);
    }

    private Position descending(int index) {
        Position position = new Position(index);
        for (Row row : rows) {
            position = getNextPosition(row, position);
        }

        return position;
    }

    private Position getNextPosition(Row row, Position position) {
        return row.move(position);
    }
}
