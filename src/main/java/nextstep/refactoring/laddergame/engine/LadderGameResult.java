package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.laddergame.engine.player.Player;
import nextstep.refactoring.laddergame.engine.reward.Reward;

public interface LadderGameResult {

    Player getPlayer();
    Reward getReward();

}
