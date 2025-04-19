package nextstep.ladder.model.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_PLAYER_COUNT = 2;
    private final List<Player> players;
    
    private Players(final List<Player> players) {
        validatePlayers(players);
        this.players = new ArrayList<>(players);
    }
    
    private void validatePlayers(final List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("참가자 목록은 비어있을 수 없습니다.");
        }
        
        if (players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자 수는 최소 " + MINIMUM_PLAYER_COUNT + "명 이상이어야 합니다: " + players.size());
        }
    }
    
    public static Players from(final List<Player> players) {
        return new Players(players);
    }
    
    public Player get(final int index) {
        return players.get(index);
    }
    
    public Optional<Player> findByName(final String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst();
    }
    
    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
    
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players that = (Players) o;
        return Objects.equals(players, that.players);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
} 
