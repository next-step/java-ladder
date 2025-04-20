package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PersonNames {
    private final List<PersonName> personNames;

    public PersonNames(List<String> personNames) {
        this.personNames = personNames.stream()
                .map(PersonName::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return personNames.size();
    }

    public List<PersonName> getPersonNames() {
        return Collections.unmodifiableList(personNames);
    }

    @Override
    public String toString() {
        return personNames.stream()
                .map(PersonName::toString)
                .collect(Collectors.joining(""));
    }
}
