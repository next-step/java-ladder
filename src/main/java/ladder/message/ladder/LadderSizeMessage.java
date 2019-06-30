package ladder.message.ladder;

import ladder.core.message.Message;

public class LadderSizeMessage extends Message {
    @Override
    public boolean isLadderSizeStep() {
        return true;
    }
}
