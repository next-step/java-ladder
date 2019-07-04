package ladder.message.response.reward;

import ladder.core.message.Response;

public class RewardInput extends Response {
    @Override
    public boolean isRewardInputStep() {
        return true;
    }
}
