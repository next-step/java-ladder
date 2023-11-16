package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = List.copyOf(names);
    }

    public List<Name> getAll() {
        return this.names;
    }

    public List<PlayerResult> createResults(Lines lines) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> new PlayerResult(names.get(i), lines.findEndPoint(i)))
                .collect(Collectors.toList());
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

}
