package nextstep.ladder.domain.floor;

@FunctionalInterface
public interface FloorFactory {
    Floor generate(int numberOfPositions);
}
