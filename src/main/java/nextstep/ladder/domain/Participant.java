package nextstep.ladder.domain;

import nextstep.ladder.validator.ParticipantValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Participant {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public static Participant of(String name) {
        return ParticipantCache.valueOf(name);
    }

    private Participant(String name) {
        ParticipantValidator.validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    private static class ParticipantCache {

        /**
         * Key: 'name' String <br> Value: 'Participant' Object
         */
        static final Map<String, Participant> PARTICIPANT_CACHE = new HashMap<>();

        static Participant valueOf(String name) {
            if (PARTICIPANT_CACHE.containsKey(name)) {
                return PARTICIPANT_CACHE.get(name);
            }
            PARTICIPANT_CACHE.put(name, new Participant(name));
            return PARTICIPANT_CACHE.get(name);
        }
    }
}
