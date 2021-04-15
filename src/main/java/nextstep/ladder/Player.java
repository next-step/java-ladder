package nextstep.ladder;

import nextstep.ladder.utils.StringUtils;

import java.util.Objects;

public class Player {
    private final int MIN_POSITION = 0;
    private final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final int position;

    private Player(final String name, final int position) {
        validation(name, position);
        this.name = name;
        this.position = position;
    }

    private void validation(String name, int position) {
        if (StringUtils.isEmpty(name) || name.length() > MAX_NAME_LENGTH || position < MIN_POSITION) {
            throw new IllegalArgumentException("유효하지 않은 입력 값 입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static Player of(String name, int position) {
        return new Player(name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
