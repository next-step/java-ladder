package ladder.message.ladder;

import ladder.core.message.Response;

public class LadderSizeResponse extends Response {
    @Override
    public boolean isLadderSizeStep() {
        return true;
    }
}
