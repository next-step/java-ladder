package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Objects;

public class Player {
    public final static int MAX_LENGTH = 5;
    public final static int MIN_POSITION = 0;
    private final String name;
    private final int position;

    public Player(final String name, final int position) {
        validation(name, position);
        this.name = name;
        this.position = position;
    }

    private void validation(final String name, final int position) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과 할 수 없습니다.");
        }
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException("참가자의 사다리 선택 포지션은 0보다 작을 수 없습니다.");
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
