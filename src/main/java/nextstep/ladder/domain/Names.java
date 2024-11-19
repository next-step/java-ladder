package nextstep.ladder.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import nextstep.ladder.CommaSeparatedResult;

public class Names extends CommaSeparatedResult {

    private static final int MIN_SIZE = 2;
    private final Set<Name> names;

    public Names(List<String> names) {
        Set<Name> result = toNames(names);
        if (inValidSize(result) || hasDuplication(names.size(), result)) {
            throw new IllegalArgumentException("잘못된 이름입력입니다.");
        }
        this.names = Collections.unmodifiableSet(result);
    }

    private boolean hasDuplication(int size, Set<Name> result) {
        return size != result.size();
    }

    private static boolean inValidSize(Collection<Name> names) {
        return names.size() < MIN_SIZE;
    }

    private static Set<Name> toNames(List<String> names) {
        return names.stream().map(Name::new).collect(Collectors.toSet());
    }

    public Names(String value) {
        this(convert(value));
    }

    @Override
    public int size() {
        return names.size();
    }

    public Set<Name> getNames() {
        return this.names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
