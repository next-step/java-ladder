package nextstep.ladder.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participant {
    public static final String DELIMITER = ",";

    private final String name;

    public Participant(String name) {
        this.name = name;
    }

    public static List<Participant> parse(String inputNames) {
        String[] names = inputNames.split(DELIMITER);

        return Stream.of(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
