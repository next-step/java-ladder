package ladder.domain;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Names implements Iterable<Name>{
    private final List<Name> names;

    public Names(String[] names) {
        this(
                Arrays.stream(names)
                        .map(Name::new)
                        .collect(Collectors.toList())
        );
    }

    public Names(List<Name> names) {
        this.names = names;
    }

    public int count() {
        return names.size();
    }

    public Name get(int index) {
        return names.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }

    @Override
    public void forEach(Consumer<? super Name> action) {
        names.forEach(action);
    }

    @Override
    public Spliterator<Name> spliterator() {
        return names.spliterator();
    }
}
