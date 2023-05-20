package refactoring.domain;

import java.util.List;

public interface Line {

    int toResult(final int position);
    List<Point> getPoint();
}
