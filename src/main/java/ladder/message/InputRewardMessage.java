package ladder.message;

import ladder.core.message.Message;

public class InputRewardMessage extends Message {
    @Override
    public boolean isInputRewardStep() {
        return true;
    }
}
