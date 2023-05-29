package ladder.param;

import ladder.exception.PlayerNameArgumentException;

public class PlayerNameParam {
    private static final int MAX_NAME_SIZE = 5;
    private String playerName;

    public PlayerNameParam(String playerName) {
        if (playerName.isEmpty()) {
            throw new PlayerNameArgumentException("비워 있는 값을 입력하였습니다.");
        }

        if (playerName.length() > MAX_NAME_SIZE) {
            throw new PlayerNameArgumentException("5글자 이상의 이름입니다.");
        }
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
