package ladderGame.domain;

import ladderGame.util.RandomDirectionGenerator;

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
                .mapToObj(i -> DirectionLayer.ofGenerator(numberOfPlayer, new RandomDirectionGenerator()))
                .collect(Collectors.toList()));
    }

    public static Ladder ofDirections(List<DirectionLayer> directionLayers) {
        return new Ladder(directionLayers);
    }

    public List<DirectionLayer> getDirectionLayers() {
        return directionLayers;
    }

    public int size() {
        return directionLayers.size();
    }

    public Position ride(Position startingPosition) {
        Position position = startingPosition;
        for (DirectionLayer directionLayer : directionLayers) {
            Direction directionsByPosition = directionLayer.getDirectionsByPosition(position);
            position = position.moveBy(directionsByPosition);
        }
        return position;
    }
}
