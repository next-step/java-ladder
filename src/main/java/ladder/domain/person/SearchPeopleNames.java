package ladder.domain.person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchPeopleNames {

    private final List<PersonName> peopleNames;

    public SearchPeopleNames(String... persons) {
        this(Arrays.stream(persons)
                .map(PersonName::new)
                .collect(Collectors.toList()));
    }

    public SearchPeopleNames(List<PersonName> persons) {
        this.peopleNames = persons;
    }

    public List<PersonName> peopleNames() {
        return Collections.unmodifiableList(this.peopleNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchPeopleNames that = (SearchPeopleNames) o;
        return Objects.equals(peopleNames, that.peopleNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleNames);
    }
}
