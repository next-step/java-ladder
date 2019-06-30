package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<String> nameStrings) {
        this.names = nameStrings.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
