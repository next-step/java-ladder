package ladder.strategy;

public interface LadderGenerationStrategy {
    boolean first();

    boolean next(boolean prev);
}