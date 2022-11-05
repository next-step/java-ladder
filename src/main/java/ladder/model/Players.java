package ladder.model;

import ladder.exception.WrongParameterException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Players {
    private static final String ALL_PLAYER = "all";
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String[] playersName) {
        List<Player> players = Arrays.stream(playersName)
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public Player getPlayer(int number) {
        return players.get(number);
    }

    public Optional<Integer> findPlayerNumber(String name) {
        if (ALL_PLAYER.equals(name)) {
            return Optional.empty();
        }

        for (int number = 0; number < players.size(); number++) {
            Player tmp = players.get(number);
            if (tmp.isEqualName(name)) {
                return Optional.of(number);
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
