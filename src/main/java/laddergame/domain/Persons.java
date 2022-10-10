package laddergame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    List<PersonName> names;

    public Persons(List<PersonName> names) {
        validateDuplicate(names);
        this.names = names;
    }

    public Persons(String[] names) {
        this(Arrays.stream(names)
                .map(PersonName::new)
                .collect(Collectors.toList()));
    }

    private void validateDuplicate(List<PersonName> names) {
        HashSet<PersonName> collect = new HashSet<>(names);
        if (collect.size() < names.size()) {
            throw new IllegalArgumentException("이름에 중복 값이 입력되었습니다.");
        }
    }

    public int numberOfPersons() {
        return names.size();
    }

    public List<PersonName> getNames() {
        return Collections.unmodifiableList(names);
    }
}
