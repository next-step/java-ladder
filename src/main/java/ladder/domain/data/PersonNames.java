package ladder.domain.data;

import java.util.*;
import java.util.stream.Collectors;

import ladder.domain.exception.LadderException;

public class PersonNames {

    private final List<Name> names;

    public PersonNames(String[] names) {
        this(Arrays.stream(names)
            .map(Name::new)
            .collect(Collectors.toList())
        );
    }

    public PersonNames(List<Name> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private void validate(List<Name> names) {
        if (!isValid(names)) {
            throw new LadderException("중복된 이름이 있습니다.");
        }
    }

    private boolean isValid(List<Name> names) {
        return names.size() == new HashSet<>(names).size();
    }

    public int size() {
        return names.size();
    }

    @Override
    public String toString() {
        return names.stream()
            .map(Name::toString)
            .collect(Collectors.joining());
    }
}
