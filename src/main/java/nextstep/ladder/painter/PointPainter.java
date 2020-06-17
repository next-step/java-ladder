package nextstep.ladder.painter;

import nextstep.ladder.point.Point;
import nextstep.ladder.point.Points;

public interface PointPainter {

	Points drawPoints(int count);

	Point drawPoint(boolean isLastPoint, boolean isConnectedToPreceding);
}
