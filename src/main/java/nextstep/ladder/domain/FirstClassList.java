package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FirstClassList<T> {
    private static final int HEAD_INDEX = 0;

    private final List<T> collection;

    protected FirstClassList(List<T> collection) {
        this.collection = Collections.unmodifiableList(collection);
    }

    // todo refactor: test에서만 사용
    public List<T> collect() {
        return collection;
    }

    // todo refactor: test에서만 사용
    public Stream<T> stream() {
        return collection.stream();
    }

    // todo refactor: test에서만 사용
    public void forEach(Consumer<? super T> action) {
        collection.forEach(action);
    }

    public int size() {
        return collection.size();
    }

    public T elementOf(int index) {
        return collection.get(index);
    }

    // todo refactor: test에서만 사용
    public Optional<T> elementOfOpt(int index) {
        if (index < HEAD_INDEX || index >= collection.size()) {
            return Optional.empty();
        }

        return Optional.of(collection.get(index));
    }

    public int indexOf(T t) {
        return collection.indexOf(t);
    }

    // todo refactor: test에서만 사용
    public Iterator<T> iterator() {
        return collect().iterator();
    }

    // todo refactor: test에서만 사용
    public <S> boolean hasSameSize(FirstClassList<S> other) {
        return other != null && collection.size() == other.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstClassList<?> that = (FirstClassList<?>) o;
        return Objects.equals(collection, that.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection);
    }

    @Override
    public String toString() {
        return "{" +
                "collection=" + collection +
                '}';
    }
}

