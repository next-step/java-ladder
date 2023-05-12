package ladder.model.participant;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Names implements Iterable<Name> {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = Collections.unmodifiableList(names);
    }

    public static Names of(String... names) {
        return new Names(Arrays.stream(names)
                .map(Name::new)
                .collect(toList())
        );
    }

    public static Names of(Name... names) {
        return new Names(List.of(names));
    }

    public int size() {
        return names.size();
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }

    public Stream<Name> stream() {
        return names.stream();
    }

    public boolean contains(Name name) {
        return names.contains(name);
    }

    public int indexOf(Name name) {
        return names.indexOf(name);
    }
}
