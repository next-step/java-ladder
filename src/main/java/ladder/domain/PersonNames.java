package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonNames {

    private final List<Name> personNames;

    public PersonNames(String[] personNames) {
        this.personNames = Arrays.stream(personNames)
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public int size() {
        return personNames.size();
    }

    @Override
    public String toString() {
        return personNames.stream()
            .map(Name::toString)
            .collect(Collectors.joining());
    }
}
