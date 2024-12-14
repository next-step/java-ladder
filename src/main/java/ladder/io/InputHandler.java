package ladder.io;

import ladder.domain.Players;
import ladder.domain.engine.Rewards;

public interface InputHandler {

    Players createPlayers();

    Rewards createRewards();

    int getHeightOfLadderFromUser();

}
