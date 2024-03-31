package nextstep.ladder.domain;

import java.util.Objects;

public class ParticipantV2 {

    private final Name name;

    public ParticipantV2(String name) {
        this.name = new Name(name);
    }

    public ParticipantV2(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantV2)) return false;
        ParticipantV2 that = (ParticipantV2) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Name getName() {
        return name;
    }
}
