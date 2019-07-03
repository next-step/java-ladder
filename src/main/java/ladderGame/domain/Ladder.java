package ladderGame.domain;

import ladderGame.util.RandomRungsGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<DirectionLayer> directionLayers;

    private Ladder(List<DirectionLayer> directionLayers) {
        this.directionLayers = directionLayers;
    }

    public static Ladder of(int numberOfPlayer, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> DirectionLayer.ofGenerator(numberOfPlayer, new RandomRungsGenerator()))
                .collect(Collectors.toList()));
    }

    public List<DirectionLayer> getDirectionLayers() {
        return directionLayers;
    }

    public int size() {
        return directionLayers.size();
    }

    public void rideLadder(Player player) {
        directionLayers.forEach(player::ride);
    }
}
