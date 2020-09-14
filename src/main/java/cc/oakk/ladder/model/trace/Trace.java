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
        int offset = line.move(position);
        return of(position + offset);
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
