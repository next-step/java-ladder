package ladder.message;

import ladder.core.message.Message;

public class InputGamersMessage extends Message {
    @Override
    public boolean isGamerStep() {
        return true;
    }
}
