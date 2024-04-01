package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {
    private final List<Name> names;

    public Participants(String[] input) {
        this.names = Stream.of(input)
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
