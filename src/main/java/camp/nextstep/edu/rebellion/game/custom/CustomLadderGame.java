package camp.nextstep.edu.rebellion.game.custom;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.position.MovedPosition;
import camp.nextstep.edu.rebellion.domain.position.MovedPositions;
import camp.nextstep.edu.rebellion.domain.rule.DrawingRule;
import camp.nextstep.edu.rebellion.game.LadderGame;
import camp.nextstep.edu.rebellion.view.PrintableLadder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomLadderGame extends LadderGame {
    private static final  int INIT_INDEX = 0;
    private final Ladder ladder;

    public CustomLadderGame(Players players, int rows, DrawingRule drawingRule) {
        super(players, rows);
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
        make(drawingRule);
    }

    public Ladder getLadder() {
        return ladder;
    }

    private void make(DrawingRule drawingRule) {
        for (int row = 0; row < rows; row++) {
            draw(row, drawingRule);
        }
    }

    private void draw(int positionOfRow, DrawingRule drawingRule) {
        IntStream
                .range(INIT_INDEX, players.getCountOfPlayers() - 1)
                .forEach(col -> {
                    if (drawingRule.canDraw()) {
                        ladder.drawLine(positionOfRow, col);
                    }
                });
    }

    @Override
    public PrintableLadder makePrintableLadder() {
        return new PrintableLadder(ladder.getRows(),
                players.getCountOfPlayers());
    }

    @Override
    public MovedPositions run(String name) {
        return players.getPlayers()
                .stream()
                .filter(p -> COMMAND_ALL.equals(name) || p.match(name))
                .map(p -> new MovedPosition(p.getName(), ladder.getFinalPosition(p.getPosition())))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        MovedPositions::new));
    }
}
