package ladder.model.participant;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Names implements Iterable<Name> {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public Names(Name... names) {
        this.names = List.of(names);
    }

    public static Names of(String... names) {
        return new Names(Arrays.stream(names)
                .map(Name::new)
                .collect(toList())
        );
    }

    public int size() {
        return names.size();
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }
}
