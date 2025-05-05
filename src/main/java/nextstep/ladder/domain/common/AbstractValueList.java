package nextstep.ladder.domain.common;

import java.util.List;

public abstract class AbstractValueList<T> {
    protected final List<T> values;

    protected AbstractValueList(List<T> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("리스트는 비어 있을 수 없습니다.");
        }
        this.values = List.copyOf(values);
    }

    public List<T> values() {
        return values;
    }

    public int count() {
        return values.size();
    }

    public T get(int index) {
        return values.get(index);
    }

    public int positionOf(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("찾는 값은 null일 수 없습니다.");
        }

        return values.indexOf(value);
    }
}
