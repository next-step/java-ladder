package ladder.domain.engine;

import java.util.List;

public interface Line {
    public int move(int position);
    public List<Point> points();
}
