package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.line.Line;

import java.util.Objects;

public class LadderUser {
    private final String name;
    private final Position position;

    public LadderUser(String name, int position) {
        this(name, new Position(position));
    }

    public LadderUser(String name, Position position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public LadderUser move(Line line) {
        if (position.canMoveLeft(line)) {
            return new LadderUser(name, position.moveLeft());
        }

        if (position.canMoveRight(line)) {
            return new LadderUser(name, position.moveRight());
        }
        return this;
    }

    public boolean isSameName(LadderUser ladderUser) {
        return Objects.equals(this.name, ladderUser.name);
    }

    public boolean isSamePosition(LadderUser ladderUser) {
        return position.equals(ladderUser.position);
    }

    public String getName() {
        return name;
    }

    public LadderPrize select(LadderPrizes ladderPrizes) {
        return ladderPrizes.get(position.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderUser that = (LadderUser) o;
        return Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "LadderUser{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}
