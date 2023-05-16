package ladder.domain.strategy;


public interface NextPointGenerationStrategy {

  boolean first();
  boolean nextBoolean(boolean prev);

}
