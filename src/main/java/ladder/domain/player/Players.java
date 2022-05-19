package ladder.domain.player;

import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    private void validate(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("players는 빈 값일 수 없습니다.");
        }

        if (players.size() < MIN_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(String.format("players(%s명)는 %s명 보다 적을 수  없습니다.", players.size(), MIN_NUMBER_OF_PLAYERS));
        }

        if (nameIsDuplicated(players)) {
            throw new IllegalArgumentException("player 이름은 중복 될 수 없습니다.");
        }
    }

    private boolean nameIsDuplicated(List<Player> players) {
        return players.size() !=
                players.stream()
                        .map(Player::toString)
                        .distinct()
                        .count();

    }

    public static Players from(List<String> playerNames) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }

        return new Players(players);
    }

    public int numbers() {
        return players.size();
    }

    public Player findByName(Name name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("플레이어가 존재하지 않습니다."));
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    @Override
    public String toString() {
        return players.stream()
                .map(player -> OutputView.nameToDisplayingName(player.toString()))
                .collect(Collectors.joining());
    }
}
