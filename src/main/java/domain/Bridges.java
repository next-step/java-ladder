package domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {

    private final Map<Height, Bridge> heightToBridges;

    public Bridges(int height) {
        this(new Height(height));
    }

    public Bridges(Height height) {
        this.heightToBridges = IntStream.rangeClosed(1, height.getHeight())
                .mapToObj(Height::new)
                .collect(Collectors.toMap(h -> h, h -> new Bridge()));
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
}
