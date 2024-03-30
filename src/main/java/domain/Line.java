package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Line {

    private final Height height;
    private final Map<Integer, Boolean> heightToBridges;

    public Line(int height) {
        this(new Height(height));
    }

    public Line(Height height) {
        this.height = height;
        heightToBridges = new HashMap<>();
    }

    public void addBridges(Line prev) {
        IntStream.range(0, height.height())
                .forEach(i -> this.addBridge(i, !prev.hasBridge(i)));
    }

    private void addBridge(int height, boolean value) {
        heightToBridges.put(height, value);
    }

    public boolean hasBridge(int height) {
        return heightToBridges.getOrDefault(height, false);
    }

    public int height() {
        return height.height();
    }
}
