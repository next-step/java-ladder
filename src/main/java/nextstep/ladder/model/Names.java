package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Iterator;

public class Names implements Iterable<Name>{
    private final Name[] names;

    public Names(String[] names) {
        this.names = Arrays.stream(names)
            .map(Name::new)
            .toArray(Name[]::new);
    }

    public int size() {
        return names.length;
    }

    @Override
    public Iterator<Name> iterator() {
        return Arrays.stream(names).iterator();
    }
}
