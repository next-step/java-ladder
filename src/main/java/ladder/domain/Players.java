package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateNames(names);

        AtomicInteger location = new AtomicInteger();
        this.players = names
                .stream()
                .map(name -> new Player(name, location.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public int getCountOrPerson() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public String getPlayerName(int idx) {
        return this.players.get(idx).getName();
    }

    private void validateNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }
    }

    public boolean hasPlayerName(String playerName) {
        return players.stream()
                .anyMatch(player -> player.equalsName(playerName));
    }
}
