package ladder.backEnd.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Names {

    private List<Name> values;

    public Names(List<Name> values) {
        this.values = values;
    }

    public static Names create(List<String> names) {
        return new Names(names.stream()
                .map(Name::new)
                .collect(toList()));
    }

    public int howManyPerson() {
        return values.size();
    }

    public List<Name> getValues() {
        return values;
    }
}
