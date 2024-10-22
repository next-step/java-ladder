package laddergame.v1.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LIMIT = 5;

    private final String name;
    private final Position startPosition;

    public Player(String name, int startPosition) {
        this(name, new Position(startPosition));
    }

    public Player(String name, Position startPosition) {
        if(name.length() > NAME_LIMIT){
            throw new IllegalArgumentException(String.format("플레이어의 이름을 %d자 이하로 입력해주세요.", NAME_LIMIT));
        }
        this.name = name;
        this.startPosition = startPosition;
    }

    public boolean isSamePosition(int otherPosition) {
        return this.startPosition.same(otherPosition);
    }

    public boolean doesNotSamePosition(int otherPosition) {
        return !isSamePosition(otherPosition);
    }

    public boolean isSameName(String otherName) {
        return otherName.equals(name);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return startPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(startPosition, player.startPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startPosition);
    }
}
