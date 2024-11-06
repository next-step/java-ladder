package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connection {
    private static final Map<Boolean, Connection> cashValue = new HashMap<>();

    static {
        cashValue.put(true, new Connection(true));
        cashValue.put(false, new Connection(false));
    }

    private final boolean value;

    private Connection(boolean value) {
        this.value = value;
    }

    public static void connect(List<Connection> lines, boolean isConnect) {
        lines.add(cashValue.get(isConnect));
    }

    public boolean isConnect() {
        return value;
    }
}
