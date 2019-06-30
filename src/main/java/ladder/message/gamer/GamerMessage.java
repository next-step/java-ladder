package ladder.message.gamer;

import ladder.core.message.Message;

public class GamerMessage extends Message {
    @Override
    public boolean isGamerStep() {
        return true;
    }
}
