package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Participants {
    private final List<Name> names;
    private final NumberOfParticipants numberOfParticipants;

    private Participants(List<String> names) {
        this.names = names.stream()
                .map(Name::valueOf)
                .collect(Collectors.toList());
        numberOfParticipants = NumberOfParticipants.valueOf(names.size());
    }

    public static Participants from(List<String> names) {
        return new Participants(names);
    }

    public NumberOfParticipants getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    public void namesValueForEach(Consumer<String> consumer) {
        names.stream()
                .map(name -> name.value)
                .forEach(consumer);
    }
}
