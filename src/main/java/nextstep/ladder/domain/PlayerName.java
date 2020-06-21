package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.lang3.StringUtils;

public class PlayerName {

    private String playerName;

    private PlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static PlayerName of(String playerName) {
        validateUserName(playerName);
        return new PlayerName(playerName);
    }

    public static PlayerName playerNameWithPadding(String playerName) {
        return new PlayerName(playerName);
    }

    public String convertUserNameWithLeftPad() {
        return StringUtils.leftPad(this.playerName, LadderConstants.MAXIMUM_USER_NAME_LENGTH + 1);
    }

    private static void validateUserName(String userName) {
        if (userName.length() > LadderConstants.MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException(LadderConstants.INVALID_USER_NAME_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return this.playerName;
    }
}
