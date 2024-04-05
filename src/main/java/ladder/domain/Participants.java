package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {
    private final List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants generateParticipants(String[] input) {
        final List<Name> names = Stream.of(input)
                .map(Name::new)
                .collect(Collectors.toList());
        return new Participants(names);
    }

    public List<Name> names() {
        return names;
    }

    public int countOfPerson() {
        return names.size();
    }
}
