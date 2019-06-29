package nextstep.ladder.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Persons {
    private Set<Person> persons;

    public Persons(List<String> names) {
        this.persons = names.stream()
                .map(Person::new)
                .collect(Collectors.toSet());
    }

    public int size() {
        return persons.size();
    }
}
