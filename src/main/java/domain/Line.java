package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Line {

    private final Height height;
    private final Map<Integer, Bridge> heightToBridges;

    public Line(int height) {
        this(new Height(height));
    }

    public Line(Height height) {
        this.height = height;
        heightToBridges = new HashMap<>();
    }

    public static Line createWithBridges(Height height, BridgeCreationStrategy bridgeCreationStrategy) {
        Line line = new Line(height);
        line.addBridges(bridgeCreationStrategy);
        return line;
    }

    public void resetBridges(Line prev) {
        IntStream.range(0, height.height())
                .filter(prev::hasBridge)
                .forEach(i -> this.addBridge(i, false));
    }

    public void addBridges(BridgeCreationStrategy bridgeCreationStrategy) {
        IntStream.range(0, height.height())
                .forEach(i -> this.addBridge(i, bridgeCreationStrategy.isCreate()));
    }

    private void addBridge(int height, boolean isBridge) {
        heightToBridges.put(height, new Bridge(isBridge));
    }

    public boolean hasBridge(int height) {
        return heightToBridges.getOrDefault(height, new Bridge(false)).has();
    }

    public int height() {
        return height.height();
    }
}
