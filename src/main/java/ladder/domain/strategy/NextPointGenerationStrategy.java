package ladder.domain.strategy;

@FunctionalInterface
public interface NextPointGenerationStrategy {

  boolean nextBoolean(boolean prev);

}
