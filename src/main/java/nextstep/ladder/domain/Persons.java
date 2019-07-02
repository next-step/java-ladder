package nextstep.ladder.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Persons {
    private Set<Person> persons;

    private Persons() {
    }

    public Persons(List<String> names) {
        this.persons = names.stream()
                .map(Person::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public int size() {
        return persons.size();
    }

    public Stream<Person> stream() {
        return persons.stream();
    }
}
