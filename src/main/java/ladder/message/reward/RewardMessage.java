package ladder.message.reward;

import ladder.core.message.Message;

public class RewardMessage extends Message {
    @Override
    public boolean isRewardStep() {
        return true;
    }
}
