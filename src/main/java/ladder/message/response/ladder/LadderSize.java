package ladder.message.response.ladder;

import ladder.core.message.Response;

public class LadderSize extends Response {
    @Override
    public boolean isLadderSizeStep() {
        return true;
    }
}
