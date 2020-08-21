package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.domain.rule.DrawingRule;

import java.util.stream.IntStream;

public class LadderGame {
    private final static int INIT_INDEX = 0;

    private final int rows;
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, int rows) {
        this.players = players;
        this.rows = rows;
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
    }

    public Ladder make(DrawingRule drawingRule) {
        IntStream
                .range(INIT_INDEX, rows)
                .forEach(row -> draw(row, drawingRule));
        return ladder;
    }

    // Players 를 가지고 있으니 Ladder 에 run 을 이용하여 경기 결과를 생성하는 역할을 하도록 함
    private void draw(int positionOfRow, DrawingRule drawingRule) {
        IntStream
                .range(INIT_INDEX, players.getCountOfPlayers() - 1)
                .forEach(col -> {
                    if (drawingRule.canDraw()) {
                        ladder.drawLine(positionOfRow, col);
                    }
                });
    }
}
