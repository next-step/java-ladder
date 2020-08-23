package ladder.domain.core.line.name;

import java.util.Objects;

final class Participant extends BaseName {
    Participant(String name) {
        super(name);
        verifySuitableName(name);
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
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
