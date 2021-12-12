package nextstep.ladder.domain;

import static nextstep.ladder.utils.StringUtils.rangeStringLength;

import java.util.Objects;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final int position;

    public Participant(String name, int position) {
        this.name = rangeStringLength(name, MAX_NAME_LENGTH);
        this.position = position;
    }

    public Participant climb(Ladder ladder) {
        int tempPosition = this.position;

        for (Line line : ladder.getLines()) {
            tempPosition = line.move(tempPosition);
        }

        return new Participant(this.name, tempPosition);
    }

    public boolean isEqualsName(String findName) {
        return this.name.equals(findName);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
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
        return getPosition() == that.getPosition() && Objects.equals(getName(),
            that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }

}
