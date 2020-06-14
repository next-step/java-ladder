package ladder.domain;

@FunctionalInterface
public interface PointGenerationStrategy {
    boolean generate();
}
