package cc.oakk.ladder.model.trace;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import cc.oakk.ladder.model.line.Line;

public class Trace {
    private static Map<Integer, Trace> INSTANCES = new HashMap<>();

    private final int position;

    private Trace(int position) {
        this.position = position;
    }

    public static Trace of(int position) {
        if (INSTANCES.containsKey(position)) {
            return INSTANCES.get(position);
        }
        Trace trace = new Trace(position);
        INSTANCES.put(position, trace);
        return trace;
    }

    public Trace move(Line line) {
        if (isLeftMovable(line)) {
            return Trace.of(position - 1);
        }
        
        if (isRightMovable(line)) {
            return Trace.of(position + 1);
        }
        return this;
    }

    private boolean isLeftMovable(Line line) {
        return position != 0 && line.isConnected(position - 1);
    }

    private boolean isRightMovable(Line line) {
        return position != line.width() - 1 && line.isConnected(position);
    }

	public int get() {
		return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trace)) {
            return false;
        }
        Trace trace = (Trace) o;
        return position == trace.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
