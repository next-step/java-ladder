package ladder.domain;

import java.util.List;

import static ladder.util.ListUtil.listOfString;

public class Players {
    private final List<String> playerName;

    public Players(String[] playerName) {
        List<String> tempList = listOfString(playerName);
        isValidPlayersName(tempList);
        this.playerName = tempList;
    }

    public List<String> getPlayers() {
        return this.playerName;
    }

    public void isValidPlayersName(List<String> playerName) {
        playerName.forEach( name -> {
            if(name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("이름은 1 ~ 5글자 사이 입력 가능합니다.");
            }
        });
    }
}
