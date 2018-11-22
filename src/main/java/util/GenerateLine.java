package util;

import domain.Point;
import domain.Line;

public interface GenerateLine {

    Point fromRandom();

    Point fromMiddle(final Line line, final int sequence);

    Point fromLast();

}
