package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {

    private final Map<Height, Bridge> heightToBridges;
    private final List<Bridge> bridges;

    public Bridges(int height) {
        this(new Height(height));
    }

    public Bridges(Height height) {
        this.heightToBridges = IntStream.range(0, height.getHeight())
                .mapToObj(Height::new)
                .collect(Collectors.toMap(h -> h, h -> new Bridge()));
        this.bridges = new ArrayList<>();
    }

    public Bridges(List<Bridge> bridges) {
        this.heightToBridges = new HashMap<>();
        this.bridges = bridges;
    }

    public void create(int height) {
        heightToBridges.put(new Height(height), new Bridge(true));
    }

    public boolean has(int height) {
        return heightToBridges.getOrDefault(new Height(height), new Bridge()).has();
    }

    public void remove(int height) {
        this.heightToBridges.put(new Height(height), new Bridge());
    }

    public Direction move(int column) {
        return bridges.get(column).move();
    }

    public int total() {
        return this.bridges.size();
    }
}
