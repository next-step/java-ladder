package ladder;

@FunctionalInterface
public interface DrawingPointsStrategy {
	LadderLinePoints draw(int playersCount);
}
