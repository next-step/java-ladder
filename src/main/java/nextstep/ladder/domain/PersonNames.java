package nextstep.ladder.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonNames {
    private final List<PersonName> personNames;

    public PersonNames(Set<String> personNames) {
        this.personNames = personNames.stream()
                .map(PersonName::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return personNames.stream()
                .map(PersonName::toString)
                .collect(Collectors.joining(""));
    }
}
