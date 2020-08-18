package camp.nextstep.edu.rebellion.domain;

import java.util.stream.IntStream;

public class LadderGame {
    private final int rows;
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, int rows) {
        this.players = players;
        this.rows = rows;
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
    }

    public Ladder make() {
        IntStream
                .range(0, rows)
                .forEach(row -> draw(row, 0));
        return ladder;
    }

    private void draw(int positionOfRow, int startingPoint) {
        IntStream
                .range(startingPoint, players.getCountOfPlayers() - 1)
                .forEach(col -> ladder.drawLine(positionOfRow, col));
    }
}
