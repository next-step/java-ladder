package ladder.message.response.result;

import ladder.core.message.Response;

public class GamerNameInput extends Response {
    @Override
    public boolean isGamerNameInputStep() {
        return true;
    }
}
