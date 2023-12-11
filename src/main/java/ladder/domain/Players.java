package ladder.domain;

import java.util.List;

public class Players {
    private static final int MAX_LENGTH = 5;

    private final List<String> playerName;

    public Players(String[] playerName) {
        List<String> tempList = List.of(playerName);
        isValidPlayersName(tempList);
        this.playerName = tempList;
    }

    public List<String> getPlayers() {
        return this.playerName;
    }

    public void isValidPlayersName(List<String> playerName) {
        playerName.forEach( name -> {
            if(name.isEmpty() || name.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("이름은 1 ~ 5글자 사이 입력 가능합니다.");
            }
        });
    }
}
