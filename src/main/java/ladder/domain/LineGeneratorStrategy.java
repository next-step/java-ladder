package ladder.domain;

@FunctionalInterface
public interface LineGeneratorStrategy {
    boolean nextBoolean();
}
