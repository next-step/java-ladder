package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinesTest {

	@Test
	void 라인들은_플레이어의_숫자보다_1작다(){
		Lines lines = new Lines(4);
		assertThat(lines.size()).isEqualTo(3);
	}

}
