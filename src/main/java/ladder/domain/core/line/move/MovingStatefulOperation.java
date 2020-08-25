package ladder.domain.core.line.move;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import ladder.domain.core.StatefulOperation;

final class MovingStatefulOperation<T, V> extends StatefulOperation<T, V> {
    MovingStatefulOperation(List<T> lines) {
        super(lines);
    }

    void each(BiFunction<T, V, V> f) {
        int size = targetSize();
        for (int i = 1; size > i; ++i) {
            final int prevIndex = i - 1;
            addState((e) -> f.apply(e, state(prevIndex)));
        }
    }

    MovingStatefulOperation<T, V> saveIndexAfterMoved(Function<T, V> stateFunction) {
        addState(stateFunction);
        return this;
    }

    MovingStatefulOperation<T, V> saveEachIndexAfterMoved(BiFunction<T, V, V> f) {
        each(f);
        return this;
    }

    List<V> toSavedIndexList(){
        return states();
    }
}
