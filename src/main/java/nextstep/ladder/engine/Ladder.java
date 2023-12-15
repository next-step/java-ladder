package nextstep.ladder.engine;

import nextstep.ladder.domain.GameResults;
import nextstep.ladder.domain.Rows;
import nextstep.ladder.domain.Width;

public interface Ladder {
	GameResults play(Width width);
	Rows rows();
}
