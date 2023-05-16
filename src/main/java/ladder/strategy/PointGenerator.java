package ladder.strategy;

@FunctionalInterface
public interface PointGenerator {

	boolean point(boolean current);
}
