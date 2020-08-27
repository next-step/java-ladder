package camp.nextstep.edu.rebellion.game;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.position.MovedPositions;
import camp.nextstep.edu.rebellion.view.PrintableLadder;

public abstract class LadderGame {
    protected static final String COMMAND_ALL = "all";

    protected final Players players;
    protected final int rows;

    public LadderGame(Players players, int rows) {
        this.players = players;
        this.rows = rows;
    }

    public abstract MovedPositions run(String name);
    public abstract PrintableLadder makePrintableLadder();
}
