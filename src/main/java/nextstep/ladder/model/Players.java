package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final String MESSAGE_CANT_PLAY_THE_GAME_ALONE = "혼자서는 사다리게임을 할 수 없습니다.";
    private static final String EXCEPTION_NOT_FOUND_PLAYER = "플레이어를 찾을 수 없습니다.";
    private static final int PLAYERS_MIN_SIZE = 1;

    private final List<Player> players;

    public Players(String[] splitNames) {
        this.players = convertToPlayers(splitNames);
    }

    private List<Player> convertToPlayers(String[] splitNames) {
        return IntStream.range(0, validationSize(splitNames))
                .mapToObj(index -> new Player(splitNames[index], new Index(index)))
                .collect(Collectors.toList());

    }

    private int validationSize(String[] splitNames) {
        if (splitNames.length == PLAYERS_MIN_SIZE) {
            throw new IllegalArgumentException(MESSAGE_CANT_PLAY_THE_GAME_ALONE);
        }
        return splitNames.length;
    }

    public Player findPlayerByName(String name) {
        return players.stream()
                .filter(player -> name.equals(player.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_NOT_FOUND_PLAYER));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
