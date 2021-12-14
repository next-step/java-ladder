package nextstep.ladder.domain;

import static nextstep.ladder.utils.StringUtils.rangeStringLength;

import java.util.Objects;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final Position position;

    public Participant(String name, Position position) {
        this.name = rangeStringLength(name, MAX_NAME_LENGTH);
        this.position = position;
    }

    public Participant climb(Ladder ladder) {
        return new Participant(this.name, ladder.execute(position));
    }

    public boolean isEqualsName(String findName) {
        return this.name.equals(findName);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(
            getPosition(), that.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }

}
