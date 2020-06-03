package ladder.domain.ladder.strategy;

@FunctionalInterface
public interface StairGenerationStrategy {
    boolean isGeneratable();
}
