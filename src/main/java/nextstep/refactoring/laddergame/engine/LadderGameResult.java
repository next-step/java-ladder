package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.laddergame.engine.player.Player;
import nextstep.refactoring.laddergame.engine.reward.Reward;
import nextstep.refactoring.view.interfaces.ViewObject;

public interface LadderGameResult extends ViewObject<LadderGameResultDto> {

    Player getPlayer();
    Reward getReward();

}
