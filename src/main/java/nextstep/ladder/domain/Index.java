package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Index {
    private static final Map<Integer, Index> cache = new HashMap<>();
    static {
        IntStream.range(0, 10)
                .forEach(number -> cache.put(number, new Index(number)));
    }
    public static final Index HEAD = cache.get(0);

    private final int index;

    private Index(int index) {
        this.index = index;
    }

    public static Index of(int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (index < HEAD.toInt()) {
            throw new IllegalArgumentException("index must be larger than or equal to 0");
        }

        Index newIndex = new Index(index);
        cache.put(index, newIndex);

        return newIndex;
    }

    public int toInt() {
        return index;
    }

    public Index next() {
        return of(index + 1);
    }

    public Index jump(int jump) {
        return of(index + jump);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index1 = (Index) o;
        return index == index1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "Index{" +
                "index=" + index +
                '}';
    }
}
