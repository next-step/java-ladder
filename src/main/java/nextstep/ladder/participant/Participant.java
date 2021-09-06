package nextstep.ladder.participant;

import java.util.Objects;

public class Participant {

    private final String name;

    public Participant(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isEmpty(name) || isOverLength(name))
            throw new IllegalArgumentException();
    }

    private boolean isEmpty(String name) {
        return Objects.isNull(name) || name.isEmpty();
    }

    private boolean isOverLength(String name) {
        return name.length() > 5;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
