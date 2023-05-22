package ladder.domain.model;

import ladder.exception.PlayerNameLengthArgumentException;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public PlayerName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new PlayerNameLengthArgumentException("최대이름 글자를 초과하였습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
