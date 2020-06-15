package ladder.domain;

@FunctionalInterface
public interface DrawingPointStrategy {
	LadderLinePoint drawPoint();
}
