package ladder;

import java.util.Objects;

public class ParticipantName {

    private final String name;

    public ParticipantName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name is too long");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ParticipantName))
            return false;
        ParticipantName that = (ParticipantName)o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
