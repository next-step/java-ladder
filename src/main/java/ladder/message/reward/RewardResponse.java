package ladder.message.reward;

import ladder.core.message.Response;

public class RewardResponse extends Response {
    @Override
    public boolean isRewardStep() {
        return true;
    }
}
