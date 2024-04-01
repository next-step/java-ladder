package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Line {

    private final Height height;
    private final Bridges bridges;

    public Line(int height) {
        this(new Height(height));
    }

    public Line(Height height) {
        this.height = height;
        this.bridges = new Bridges(height);
    }

    public static Line createWithBridges(int height, BridgeCreationStrategy strategy) {
        return createWithBridges(new Height(height), strategy);
    }

    public static Line createWithBridges(Height height, BridgeCreationStrategy strategy) {
        Line line = new Line(height);
        line.addBridges(strategy);
        return line;
    }

    public void resetBridges(Line prev) {
        IntStream.rangeClosed(1, height.height())
                .filter(prev::hasBridge)
                .forEach(this::removeBridge);
    }

    public void addBridges(BridgeCreationStrategy bridgeCreationStrategy) {
        IntStream.rangeClosed(1, height.height())
                .filter(i -> bridgeCreationStrategy.isCreate())
                .forEach(this::addBridge);
    }

    private void addBridge(int height) {
        bridges.create(height);
    }

    private void removeBridge(int height) {
        bridges.remove(height);
    }

    public boolean hasBridge(int height) {
        return bridges.has(height);
    }

    public int height() {
        return height.height();
    }
}