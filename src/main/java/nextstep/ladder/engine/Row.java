package nextstep.ladder.engine;

import java.util.List;

import nextstep.ladder.domain.Point;

public interface Row {
	int move(int index);
	List<Point> values();
}
