package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public enum Pipe {
    CONNECTED(true, "-----|"),
    DISCONNECTED(false, "|");

    private static final Map<Boolean, Pipe> BY_CONNECTION = new HashMap<>();
    private boolean connection;
    private String pipe;

    static {
        BY_CONNECTION.put(true, Pipe.CONNECTED);
        BY_CONNECTION.put(false, Pipe.DISCONNECTED);
    }

    private Pipe(boolean connection, String pipe) {
        this.connection = connection;
        this.pipe = pipe;
    }

    public static Pipe of(Point point) {
        return BY_CONNECTION.get(point.isConnection());
    }

    public String getPipe() {
        return pipe;
    }
}
