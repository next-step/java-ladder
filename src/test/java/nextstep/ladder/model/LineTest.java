package nextstep.ladder.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import nextstep.ladder.model.Line;

class LineTest {

	@Test
	void 이전_라인이_잇을경우_무조건_해당라인은_없다() {
		Assertions.assertThat(Line.create(new Line(true))).isEqualTo(new Line(false));
	}

}
