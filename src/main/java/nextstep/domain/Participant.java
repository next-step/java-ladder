package nextstep.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Participant {

    private static final Map<String, Participant> participantCache = new HashMap<>();
    private final String name;

    private Participant(String name) {
        this.name = name;
    }

    public static Participant of(String name) {
        if (participantCache.get(name) == null) {
            participantCache.put(name, new Participant(name));
        }

        return participantCache.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
