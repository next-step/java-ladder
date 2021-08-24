package nextstep.ladder.exception;

import nextstep.ladder.domain.Player;

public class PlayerNotFoundException extends RuntimeException {

    private static final String MESSAGE = "해당 참가자를 찾을 수 없습니다. (이름: %s)";

    public PlayerNotFoundException(Player player) {
        super(String.format(MESSAGE, player.getName()));
    }
}
