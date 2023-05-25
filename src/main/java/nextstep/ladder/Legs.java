package nextstep.ladder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

public class Legs {
    private final Set<Position> legLeftPositions;

    public Legs(Natural height, Natural width, GenerationStrategy strategy) {
        legLeftPositions = new HashSet<>();
        placeLegs(height, width, strategy);
    }

    private void placeLegs(Natural height, Natural width, GenerationStrategy strategy) {
        LongStream.range(0, height.value())
                .mapToObj(Natural::new)
                .forEach(level -> placeLegsInLevel(level, width, strategy));
    }

    private void placeLegsInLevel(Natural level, Natural width, GenerationStrategy strategy) {
        LongStream.range(0, width.value() - 1)
                .mapToObj(Natural::new)
                .map(place -> new Position(level, place))
                .forEach(position -> placeLegWithStrategy(strategy, position));
    }

    private void placeLegWithStrategy(GenerationStrategy strategy, Position position) {
        if (isLegPlaceableOnPosition(position) && strategy.shouldPlace()) {
            legLeftPositions.add(position);
        }
    }

    private boolean isLegPlaceableOnPosition(Position position) {
        return isOnTheLeftEdge(position) || !hasLegOnRightSideOf(position.getLeftPosition());
    }

    private boolean isOnTheLeftEdge(Position position) {
        return position.place.value() == 0;
    }

    public boolean hasLegOnRightSideOf(Position position) {
        return legLeftPositions.contains(position);
    }
}
