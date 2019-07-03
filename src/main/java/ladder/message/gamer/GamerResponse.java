package ladder.message.gamer;

import ladder.core.message.Response;

public class GamerResponse extends Response {
    @Override
    public boolean isGamerStep() {
        return true;
    }
}
