package nextstep.ladder.domain.movestrategy;

import nextstep.ladder.domain.ladder.Line;

public interface PointStrategy {
	boolean isAddible(int index, Line line);
}
