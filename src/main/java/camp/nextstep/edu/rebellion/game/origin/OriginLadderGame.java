package camp.nextstep.edu.rebellion.game.origin;

import camp.nextstep.edu.rebellion.game.LadderGame;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.position.MovedPosition;
import camp.nextstep.edu.rebellion.domain.position.MovedPositions;
import camp.nextstep.edu.rebellion.view.PrintableLadder;

import java.util.stream.Collectors;

public class OriginLadderGame extends LadderGame {
    private final Ladder ladder;

    public OriginLadderGame(Players players, int rows) {
        super(players, rows);
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
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

    @Override
    public PrintableLadder makePrintableLadder() {
        return new PrintableLadder(ladder.getLines(),
                players.getCountOfPlayers());
    }
}
