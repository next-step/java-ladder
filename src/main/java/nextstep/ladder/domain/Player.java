package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final static int MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 최대 5글자까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
