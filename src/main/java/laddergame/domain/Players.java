package laddergame.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
        validate();
    }

    //region [validate]
    private void validate() {
        checkPlayerCount();
        checkPositionSequential();
    }

    private void checkPlayerCount() {
        if(players.size() < 2){
            throw new IllegalArgumentException("사다리 게임의 플레이어는 최소 2명 이상이어야 합니다");
        }
    }

    private void checkPositionSequential() {
        boolean doesNotPositionSequential = IntStream.range(0, players.size())
                .anyMatch(position -> players.get(position).doesNotSamePosition(position));

        if(doesNotPositionSequential){
            throw new IllegalStateException("플레이어의 위치가 0부터 순차적으로 증가하지 않았습니다");
        }
    }
    //endregion
    public int firstPosition(){
        return players.stream()
                .map(Player::getPosition)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("플레이어의 위치 정보가 없습니다"))
                .getPosition();
    }

    public int lastPosition(){
        return players.stream()
                .map(Player::getPosition)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("플레이어의 위치 정보가 없습니다"))
                .getPosition();
    }

    public Optional<Player> findByName(String otherName){
        return players.stream()
                .filter(player -> player.isSameName(otherName))
                .findFirst();
    }

    public Optional<Player> findByPosition(int otherPosition) {
        return players.stream()
                .filter(player -> player.isSamePosition(otherPosition))
                .findFirst();
    }

    public int size(){
        return players.size();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
