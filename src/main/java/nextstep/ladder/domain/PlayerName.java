package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(this.playerName);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PlayerName playerName = (PlayerName) obj;
        return Objects.equals(playerName.playerName, this.playerName);
    }
}
