package ladder.backEnd.domain;

import ladder.backEnd.streategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private List<Bridge> value = new ArrayList<>();
    private ConnectionStrategy connectionStrategy;

    public Line(int people, ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
        IntStream.range(0, people - 1)
                .boxed()
                .map(this::createBridge)
                .forEachOrdered(this.value::add);
    }

    private Bridge createBridge(Integer index) {
        return Bridge.create(() -> isConnectable(index), connectionStrategy);
    }

    private boolean isConnectable(int index) {
        if (index > 0 && getNeighbor(index - 1).isConnected()) {
            return false;
        }
        return true;
    }

    private Bridge getNeighbor(int index) {
        return value.get(index);
    }

    public List<Bridge> getValue() {
        return Collections.unmodifiableList(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(getValue(), line.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "Line{" +
                "value=" + value +
                '}';
    }
}
