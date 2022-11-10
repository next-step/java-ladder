package nextstep.ladder.domain.linestrategy;

import nextstep.ladder.domain.ladder.Line;

public interface LineGenerator {

	Boolean generatePoint(int index, Line line);
}
