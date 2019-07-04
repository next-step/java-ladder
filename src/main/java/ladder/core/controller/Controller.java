package ladder.core.controller;

import ladder.message.request.gamer.GamerNames;
import ladder.message.request.ladder.LadderSize;
import ladder.message.request.result.GamerName;
import ladder.message.request.reward.RewardRequest;

public interface Controller {
    void action();
    void inputGamers(GamerNames gamerNames);
    void inputReward(RewardRequest reward);
    void inputLadderSize(LadderSize ladderSize);
    void inputGamerName(GamerName gamerName);
}
