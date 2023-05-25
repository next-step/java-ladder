package nextstep.ladder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

public class Legs {
    private final Set<Position> legs;

    public Legs(Natural height, Natural width, GenerationStrategy strategy) {
        legs = new HashSet<>();
        placeLegs(height, width, strategy);
    }

    private void placeLegs(Natural height, Natural width, GenerationStrategy strategy) {
        LongStream.range(0, height.value())
                .mapToObj(Natural::new)
                .forEach(level -> placeLegsInLevel(level, width, strategy));
    }

    private void placeLegsInLevel(Natural level, Natural width, GenerationStrategy strategy) {
        LongStream.range(0, width.value())
                .mapToObj(Natural::new)
                .map(place -> new Position(level, place))
                .forEach(position -> placeLegWithStrategy(strategy, position));
    }

    private void placeLegWithStrategy(GenerationStrategy strategy, Position position) {
        var isPlaceable = isOnTheLeftEdge(position) || !hasLegOnRightSide(position.getLeftPosition());
        if (strategy.shouldPlace(isPlaceable)) {
            legs.add(position);
        }
    }

    private boolean isOnTheLeftEdge(Position position) {
        return position.place.value() == 0;
    }

    public boolean hasLegOnRightSide(Position position) {
        return legs.contains(position);
    }
}
