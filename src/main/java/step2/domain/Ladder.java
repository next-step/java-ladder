package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class Ladder {
    private final List<Layer> layers;

    private Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public static Ladder create(Height height, int countOfPerson){
        return Stream.generate(() -> Layer.of(countOfPerson))
                     .limit(height.getHeight())
                     .collect(collectingAndThen(Collectors.toList(),Ladder::new));
    }
}
