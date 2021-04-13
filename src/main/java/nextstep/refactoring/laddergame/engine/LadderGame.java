package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.laddergame.engine.player.Player;
import nextstep.refactoring.laddergame.engine.reward.Reward;

import java.util.List;

public interface LadderGame {

    List<LadderGameResult> getResult(LadderCompatibleList<Player> playerList,
                                    LadderCompatibleList<Reward> rewardList,
                                    PlayerNameKeyword keyword);

}
