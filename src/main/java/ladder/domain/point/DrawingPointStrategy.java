package ladder.domain.point;

@FunctionalInterface
public interface DrawingPointStrategy {
	LadderLinePoint drawPoint();
}
