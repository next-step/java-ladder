package domain;

import java.util.stream.IntStream;

public class Line {

    private final Height height;
    private final Bridges bridges;

    private Line(Height height) {
        this.height = height;
        this.bridges = new Bridges(height);
    }

    private Line(Height height, Bridges bridges) {
        this.height = height;
        this.bridges = bridges;
    }

    public static Line createWithBridges(int height, BridgeCreationStrategy strategy) {
        return createWithBridges(new Height(height), strategy);
    }

    public static Line createWithBridges(Height height, BridgeCreationStrategy strategy) {
        Line line = new Line(height);
        line.addBridges(strategy);
        return line;
    }

    public static Line create(Bridges bridges) {
        return new Line(new Height(bridges.total() - 1), bridges);
    }

    public void resetBridges(Line prev) {
        IntStream.range(0, height.getHeight())
                .filter(prev::hasBridge)
                .forEach(this::removeBridge);
    }

    public void addBridges(BridgeCreationStrategy bridgeCreationStrategy) {
        IntStream.range(0, height.getHeight())
                .filter(i -> bridgeCreationStrategy.isCreate())
                .forEach(this::addBridge);
    }

    private void addBridge(int height) {
        bridges.create(height);
    }

    private void removeBridge(int height) {
        bridges.remove(height);
    }

    public boolean hasBridge(Position position) {
        return this.hasBridge(position.getY());
    }

    public boolean hasBridge(int height) {
        return bridges.has(height);
    }

    public int getHeight() {
        return height.getHeight();
    }

    public Direction move(int height) {
        return this.bridges.move(height);
    }
}
