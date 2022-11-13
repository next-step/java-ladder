package ladder.model;

import ladder.exception.WrongParameterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Players {

    private static final String ALL_PLAYER = "all";

    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String[] playersName) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playersName.length; i++) {
            players.add(new Player(playersName[i], i));
        }

        return new Players(players);
    }

    public Optional<Player> findPlayer(String name) {
        if (ALL_PLAYER.equals(name)) {
            return Optional.empty();
        }

        for (int number = 0; number < players.size(); number++) {
            Player player = players.get(number);

            if (player.isEqualName(name)) {
                return Optional.of(player);
            }
        }

        throw new WrongParameterException("게임에 참여하지 않은 사람의 이름을 입력 하셨습니다.");
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }
}
