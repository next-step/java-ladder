package ladder.message.result;

import ladder.core.message.Message;

public class InputLadderSizeMessage extends Message {
    @Override
    public boolean isLadderSizeStep() {
        return true;
    }
}
