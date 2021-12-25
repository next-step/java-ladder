package nextstep.ladder.engine;

import java.util.function.Consumer;
import java.util.stream.Stream;

public interface FirstClassIndexCollection<T> {
    // product 코드에서 사용하는 메소드만 모음
    Stream<T> stream();
    void forEach(Consumer<? super T> action);
    int size();
    T elementOf(int index);
    int indexOf(T t);
}
