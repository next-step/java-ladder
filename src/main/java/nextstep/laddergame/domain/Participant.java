package nextstep.laddergame.domain;

import java.util.Objects;

public class Participant {
    private final String name;
    private final Position position;

    public Participant(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
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
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isNameEquals(String inputParticipantName) {
        return inputParticipantName.equals(name);
    }
}
