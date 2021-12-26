package nextstep.ladder.engine;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface FirstClassIndexCollection<T> {
    List<T> collect();
    Stream<T> stream();
    void forEach(Consumer<? super T> action);
    int size();
    T elementOf(int index);
    int indexOf(T t);
}
