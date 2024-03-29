package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Line {

    private final Height height;
    private final Map<Integer, Boolean> bridges;

    public Line(Height height) {
        this.height = height;
        bridges = new HashMap<>();
    }

    public void addBridges(Line prev) {
        IntStream.range(0, height.height())
                .filter(i -> !prev.hasBridge(i))
                .forEach(this::addBridge);
    }

    public void addBridge(int height) {
        bridges.put(height, true);
    }

    public boolean hasBridge(int height) {
        return bridges.getOrDefault(height, false);
    }
}
