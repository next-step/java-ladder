package ladder.domain.player;

import ladder.exception.NeedMorePlayerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {

    private static final int MIN_PERSON_NUM = 1;

    private final List<Player> playerList = new ArrayList<>();

    public Players(String playerNames) {
        String[] names = playerNames.split(",");

        validate(names);

        Arrays.stream(names).forEach(name -> playerList.add(new Player(name)));
    }

    private void validate(String[] names) {
        if (names.length == MIN_PERSON_NUM) {
            throw new NeedMorePlayerException("사다리 게임을 진행할 플레이어가 더 필요합니다");
        }
    }

    public List<Player> getPlayers() {
        return playerList;
    }

    public int getPlayerNum() { return playerList.size(); }
}
