package ladder.exception;

import static ladder.domain.Player.MAX_PLAYER_NAME;

public class PlayerNameLengthExceedException extends IllegalArgumentException {
    public PlayerNameLengthExceedException(int length) {
        super("name should be less than " + MAX_PLAYER_NAME + ", but: " + length);
    }
}
