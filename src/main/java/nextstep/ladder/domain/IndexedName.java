package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class IndexedName {
    public static final int MAX_NAME_LENGTH = 5;
    private final int index;
    private final String name;

    public IndexedName(int index, String name) {
        ensureValidParameter(index, name);
        ensureNameLength(name);
        this.index = index;
        this.name = name;
    }

    private void ensureValidParameter(int index, String name) {
        if (index < 0 || name == null) {
            throw new IllegalArgumentException("이름/인덱스가 올바르지 않습니다");
        }
    }

    private void ensureNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d자 이하여야 합니다.", MAX_NAME_LENGTH));
        }
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IndexedName that = (IndexedName) o;
        return index == that.index && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }

    public static List<String> unwrap(List<IndexedName> goals) {
        return goals.stream().map(IndexedName::toString).collect(toList());
    }

    public static List<IndexedName> wrap(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(index -> new IndexedName(index, names.get(index)))
                .collect(toList());
    }
}
