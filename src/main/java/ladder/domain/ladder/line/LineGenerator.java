package ladder.domain.ladder.line;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.line.point.LinePoint;

public class LineGenerator {

  public List<LinePoint> generateNotConnectedPoints (int countOfPerson) {
    final List<LinePoint> linePoints = new ArrayList<>(countOfPerson);

    LinePoint currentPoint = LinePoint.first();
    linePoints.add(currentPoint);

    for (int i = 1; i < countOfPerson; i++) {
      LinePoint next = currentPoint.next();
      linePoints.add(next);
      currentPoint = next;
    }

    return  linePoints;
  }
}
