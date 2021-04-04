package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Objects;

public class Player {
    public final static int MAX_LENGTH = 5;
    private final String name;

    public Player(final String name) {
        validation(name);
        this.name = name;
    }

    private void validation(final String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과 할 수 없습니다.");
        }
    }

    public String name() {
        return StringUtils.generateBlank(MAX_LENGTH - name.length()) + name;
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
