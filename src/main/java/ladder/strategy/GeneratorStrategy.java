package ladder.strategy;

@FunctionalInterface
public interface GeneratorStrategy {
    boolean generatePoint(boolean previous);
}
