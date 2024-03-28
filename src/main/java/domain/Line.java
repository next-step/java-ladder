package domain;

import java.util.HashMap;
import java.util.Map;

public class Line {

    private final Name name;
    private final int height;
    private Map<Integer, Boolean> bridges = new HashMap<>();

    public Line(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public void addBridge(int height) {
        bridges.put(height, true);
    }

    public boolean hasBridge(int height) {
        return bridges.getOrDefault(height, false);
    }
}
