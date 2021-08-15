package ladder.domain;

import ladder.exception.InvalidPersonNameException;

import java.util.*;

public class ParticipatePeople {
    private static final int NAME_LENGTH_THRESHOLD = 6;

    private final List<String> participatePeople;

    public ParticipatePeople(List<String> participatePeople) {
        validate(participatePeople);
        this.participatePeople = participatePeople;
    }

    private void validate(List<String> participatePeople) {
        participatePeople.stream()
                .filter(person -> person.length() > NAME_LENGTH_THRESHOLD)
                .findAny()
                .ifPresent(person -> {
                    throw new InvalidPersonNameException();
                });
    }

    public static ParticipatePeople of(List<String> participatePeople) {
        return new ParticipatePeople(participatePeople);
    }

    public List<String> getList() {
        return Collections.unmodifiableList(participatePeople);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipatePeople that = (ParticipatePeople) o;
        return Objects.equals(participatePeople, that.participatePeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participatePeople);
    }
}
